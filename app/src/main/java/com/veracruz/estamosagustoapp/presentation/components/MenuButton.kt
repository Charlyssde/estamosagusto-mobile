package com.veracruz.estamosagustoapp.presentation.components

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.veracruz.estamosagustoapp.R


@Composable
fun MenuButton(
    text: String,
    icon: Int,
    description: String,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = CircleShape,
                modifier = Modifier.background(Color.White)
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                    onClick = { onClick() }
                ) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = description,
                        modifier = Modifier
                            .height(75.dp)
                            .width(75.dp),
                    )
                }
            }
            Text(
                text = text,
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
            )
        }
    }

}