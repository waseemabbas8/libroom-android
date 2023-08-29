package com.waseem.libroom.core.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.waseem.libroom.core.ui.theme.LIBroomTheme
import com.waseem.libroom.core.ui.theme.LightColors


@Composable
internal fun ThemedPreview(
    darkTheme: Boolean = false,
    uiMode: UiMode = UiMode.PhonePortrait,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalUiMode provides uiMode) {
        LIBroomTheme(darkTheme = darkTheme) {
            Surface(color = LightColors.surface) {
                content()
            }
        }
    }
}
