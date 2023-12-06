package com.waseem.libroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.waseem.libroom.core.ui.theme.LIBroomTheme
import com.waseem.libroom.feature.auth.presentation.LoginScreen
import com.waseem.libroom.feature.onboarding.presentation.OnboardingScreen
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
                val authState = remember {
                    mutableIntStateOf(0)
                }
                when(authState.value) {
                    0 -> {
                        OnboardingScreen(
                            viewModel = hiltViewModel(),
                            gotoAuth = {
                                authState.value = 1
                            }
                        )
                    }
                    1 -> {
                        LoginScreen(viewModel = hiltViewModel()) {
                            authState.value = 2
                        }
                    }
                    2 -> {
                        MainScreen()
                    }
                }

            }
        }
    }
}