package com.veracruz.estamosagustoapp.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    text : String
) {
    TopAppBar (
        title = {
            Text(
                text = text,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color =  Color.White,
                    fontSize = 24.sp
                )
            )
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}