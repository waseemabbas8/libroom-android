package com.waseem.libroom.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val _darkColorScheme = darkColorScheme(
    primary = LightColors.primary,
    secondary = LightColors.secondary,
    tertiary = LightColors.tertiary
)

private val _lightColorScheme = lightColorScheme(
    primary = LightColors.primary,
    onPrimary = LightColors.onPrimary,
    primaryContainer =LightColors.primaryContainer,
    onPrimaryContainer = LightColors.onPrimaryContainer,
    inversePrimary = LightColors.inversePrimary,
    secondary = LightColors.secondary,
    onSecondary = LightColors.onSecondary,
    secondaryContainer = LightColors.secondaryContainer,
    onSecondaryContainer = LightColors.onSecondaryContainer,
    tertiary = LightColors.tertiary,
    onTertiary = LightColors.onTertiary,
    tertiaryContainer = LightColors.tertiaryContainer,
    onTertiaryContainer = LightColors.onTertiaryContainer,
    background = LightColors.background,
    onBackground = LightColors.onBackground,
    surface = LightColors.surface,
    onSurface = LightColors.onSurface,
    surfaceVariant = LightColors.surfaceVariant,
    onSurfaceVariant = LightColors.onSurfaceVariant,
    surfaceTint = LightColors.surfaceTint,
    inverseSurface = LightColors.inverseSurface,
    inverseOnSurface = LightColors.inverseOnSurface,
    error = LightColors.error,
    onError = LightColors.onError,
    errorContainer = LightColors.errorContainer,
    onErrorContainer = LightColors.onErrorContainer,
    outline = LightColors.outline,
    outlineVariant = LightColors.outlineVariant,
    scrim = LightColors.scrim
)

private val shapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

@Composable
fun LIBroomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        darkTheme -> _darkColorScheme
        else -> _lightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = shapes
    )
}