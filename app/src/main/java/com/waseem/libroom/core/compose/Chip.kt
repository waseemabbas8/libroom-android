package com.waseem.libroom.core.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.extraSmall)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
            style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    }
}

@Composable
@Preview
fun ChipPreview() {
    ThemedPreview {
        Chip(
            text = "Romance"
        )
    }
}