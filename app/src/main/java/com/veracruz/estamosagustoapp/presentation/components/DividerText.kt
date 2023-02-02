package com.veracruz.estamosagustoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DividerText(
    text : String
) {
    Surface (
        shape = RoundedCornerShape(topEnd = 5.dp, topStart = 5.dp)
    ){
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp
                )
            )
        }
    }
}