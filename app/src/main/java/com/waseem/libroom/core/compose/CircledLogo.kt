package com.waseem.libroom.core.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun CircledLogo() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(
                width = 12.dp,
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = CircleShape
            ),
    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = "onboard image",
        )
    }
}

@Composable
@Preview
private fun PreviewCircledLogo() {
    ThemedPreview {
        CircledLogo()
    }
}