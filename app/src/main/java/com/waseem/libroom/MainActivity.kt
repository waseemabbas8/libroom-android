package com.waseem.libroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.waseem.libroom.core.ui.theme.LIBroomTheme
import com.waseem.libroom.feature.auth.presentation.LoginScreen
import com.waseem.libroom.feature.onboarding.presentation.OnboardingScreen
import com.waseem.libroom.feature.root.MainScreen
import com.waseem.libroom.feature.root.domain.AuthState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.authState.value == AuthState.UNKNOWN
        }

        actionBar?.hide()

        setContent {
            LIBroomTheme {
                Crossfade(targetState = viewModel.authState.value, label = "scene") { state ->
                    when(state) {
                        AuthState.ONBOARDING -> {
                            OnboardingScreen(
                                viewModel = hiltViewModel(),
                                gotoAuth = {
                                    viewModel.setAuthState(AuthState.UNAUTHENTICATED)
                                }
                            )
                        }
                        AuthState.UNAUTHENTICATED -> {
                            LoginScreen(viewModel = hiltViewModel()) {
                                viewModel.setAuthState(AuthState.AUTHENTICATED)
                            }
                        }
                        AuthState.AUTHENTICATED -> {
                            MainScreen()
                        }
                        else -> {
                            Scaffold {
                                Box(modifier = Modifier.padding(it))
                            }
                        }
                    }
                }

            }
        }
    }
}