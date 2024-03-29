package com.veracruz.estamosagustoapp.presentation.camerascan
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import java.util.concurrent.Executors


@Composable
fun MLKitTextRecognition() {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val extractedText = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextRecognitionView(
            context = context,
            lifecycleOwner = lifecycleOwner,
            extractedText = extractedText
        )
        Text(
            text = extractedText.value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            color = Color.Black
        )
    }
}

@Composable
fun TextRecognitionView(
    context: Context,
    lifecycleOwner: LifecycleOwner,
    extractedText: MutableState<String>
) {
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var preview by remember { mutableStateOf<Preview?>(null) }
    val imageCapture: MutableState<ImageCapture?> = remember { mutableStateOf(null) }
    val executor = ContextCompat.getMainExecutor(context)
    val cameraProvider = cameraProviderFuture.get()
    val textRecognizer = remember { TextRecognition.getClient() }

    Box {
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                cameraProviderFuture.addListener({
                    val cameraSelector = CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                        .build()
                    imageCapture.value = ImageCapture.Builder().build()
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        imageCapture.value,
                        preview
                    )
                }, executor)
                preview = Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }
                previewView
            }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .align(Alignment.TopStart)
        ) {
            IconButton(
                onClick = {
                    imageCapture.value?.takePicture(executor,
                        object : ImageCapture.OnImageCapturedCallback() {
                            @SuppressLint("UnsafeOptInUsageError")
                            override fun onCaptureSuccess(imageProxy: ImageProxy) {
                                val mediaImage = imageProxy.image
                                if (mediaImage != null) {
                                    val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
                                    textRecognizer.process(image)
                                        .addOnSuccessListener {
                                            extractedText.value = it.text
                                        }

                                }
                            }

                            override fun onError(exception: ImageCaptureException) {
                                Toast.makeText(context, exception.message, Toast.LENGTH_LONG)
                                    .show()
                            }
                        })
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back",
                    tint = Color.White
                )
            }
        }
    }
}