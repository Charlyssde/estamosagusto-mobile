package com.veracruz.estamosagustoapp.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Composable
fun DateInput(
    textFieldValue: MutableState<String>,
    imeAction: ImeAction
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        var date by remember {
            mutableStateOf(
                TextFieldValue(
                    text = textFieldValue.value
                )
            )
        }

        DateTextField(
            value = textFieldValue,
            onValueChange = {
                date = it
            },
            imeAction = imeAction
        )

    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DateTextField(
    value: MutableState<String>,
    modifier: Modifier = Modifier,
    onValueChange: (TextFieldValue) -> Unit,
    imeAction: ImeAction
) {
    TextField(
        value = value.value,
        label = {
          Text(text = "dd/mm/yyyy")  
        },
        visualTransformation = DateTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth(),
        onValueChange = {
                        value.value = it
        },
    )
}

class DateTransformation() : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return dateFilter(text)
    }
}

fun dateFilter(text: AnnotatedString): TransformedText {

    val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 2 == 1 && i < 4) out += "/"
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 3) return offset +1
            if (offset <= 8) return offset +2
            return 10
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <=2) return offset
            if (offset <=5) return offset -1
            if (offset <=10) return offset -2
            return 8
        }
    }

    return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}
