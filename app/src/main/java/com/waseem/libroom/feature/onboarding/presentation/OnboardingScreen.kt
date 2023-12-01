package com.waseem.libroom.feature.onboarding.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.FilledButton
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun OnboardingScreen() {
    val view = LocalView.current
    val backgroundColor = colorScheme.secondary
    OnboardingContent(backgroundColor = backgroundColor)
}

@Composable
fun OnboardingContent(backgroundColor: Color) {
    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.book_solid),
                    tint = colorScheme.primary,
                    modifier = Modifier
                        .width(130.dp)
                        .height(130.dp),
                    contentDescription = "logo",
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayMedium.copy(color = Color.White)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(id = R.string.app_slogan),
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White.copy(alpha = 0.6F))
                )
            }
            FilledButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .align(Alignment.BottomEnd),
                text = "Get Started",
                onClick = { /*TODO*/ },
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4_XL)
@Composable
private fun Preview() {
    ThemedPreview {
        OnboardingContent(backgroundColor = Color(0xFF140e27))
    }
}