package com.waseem.libroom.feature.favorites.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun FavoritesScreen() {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Favorites Screen", style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Preview
@Composable
private fun previewHome() {
    ThemedPreview {
        FavoritesScreen()
    }
}