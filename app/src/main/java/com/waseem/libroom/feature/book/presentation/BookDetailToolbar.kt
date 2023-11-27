package com.waseem.libroom.feature.book.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun BookDetailToolbar(
    title: String,
    navigateUp: () -> Unit,
    onMenuIconClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(id = R.dimen.toolbar_bottom_margin))
    ) {
        IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                contentDescription = "Go back"
            )
        }
        Text(title, style = MaterialTheme.typography.titleMedium)
        IconButton(onClick = onMenuIconClick) {
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = "Actions"
            )
        }
    }
}

@Preview
@Composable
private fun PreviewToolbar() {
    ThemedPreview {
        BookDetailToolbar(
            title = "Book Title",
            navigateUp = {},
            onMenuIconClick = {}
        )
    }
}