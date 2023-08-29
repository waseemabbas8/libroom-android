package com.waseem.libroom.core.ui

import androidx.compose.runtime.compositionLocalOf


val LocalUiMode = compositionLocalOf<UiMode> { error("No UiMode found!") }

sealed class UiMode {
    object PhonePortrait : UiMode()
    object PhoneLandscape : UiMode()
    object DualMode : UiMode()
    object TabletPortrait : UiMode()
    object TabletLandscape : UiMode()
}
