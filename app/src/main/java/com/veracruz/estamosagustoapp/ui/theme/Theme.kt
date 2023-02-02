package com.veracruz.estamosagustoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = mainMaroon,
    primaryVariant = mainRed,
    secondary = mainGreen,
)

private val LightColorPalette = lightColors(
    primary = mainMaroon,
    primaryVariant = mainRed,
    secondary = mainGreen,
    background = grayBackground,
    onBackground = secondMaroon,
    onPrimary = secondGreen,
    /* Other default colors to overridesurface = Color.White,
    onSurface = secondGreen,
    onSecondary = Color.Black,
    */
)

@Composable
fun EstamosAgustoAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}