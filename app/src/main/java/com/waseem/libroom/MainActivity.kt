package com.waseem.libroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.waseem.libroom.core.ui.theme.LIBroomTheme
import com.waseem.libroom.feature.root.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        setContent {
            LIBroomTheme {
                MainScreen()
            }
        }
    }
}