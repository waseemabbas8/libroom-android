package com.waseem.libroom.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
private val baseTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
)

val Typography = Typography(
    bodyLarge = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = baseTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 50.sp,
    ),
    displayMedium = baseTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 45.sp,
        lineHeight = 52.sp,
    ),
    headlineLarge = baseTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
    ),
    headlineMedium = baseTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
    ),
    titleLarge = baseTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = baseTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    /* Other default text styles to override

    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)