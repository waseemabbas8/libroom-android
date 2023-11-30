package com.waseem.libroom.feature.book.presentation.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.ElevatedTile
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun BookThumbnail(
    modifier: Modifier = Modifier,
    url: String
) {
    ElevatedTile(
        modifier = modifier,
    ) {
        AsyncImage(
            model = url,
            contentDescription = "Thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            placeholder = painterResource(id = R.drawable.cover_placeholder)
        )
    }
}

@Preview
@Composable
fun PreviewBookThumbnail() {
    ThemedPreview {
        BookThumbnail(
            modifier = Modifier.padding(16.dp).width(109.dp).height(160.dp),
            url = ""
        )
    }
}