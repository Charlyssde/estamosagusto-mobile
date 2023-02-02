package com.veracruz.estamosagustoapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuButton(
    text: String,
    icon: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    Card (
        modifier = Modifier
            .width(300.dp)
            .height(250.dp)
            .padding(10.dp),
        elevation = 5.dp,
        border = BorderStroke(2.dp, MaterialTheme.colors.onPrimary),
        onClick = {onClick()},
        shape = RoundedCornerShape(15),
        contentColor = MaterialTheme.colors.onPrimary
        ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(100.dp),
                imageVector = icon,
                contentDescription = description,
            )
            Text(
                text = text,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
            )
        }
    }

}