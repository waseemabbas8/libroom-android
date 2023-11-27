package com.waseem.libroom.core.compose

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
fun Toolbar(
    title: String,
    navigateUp: () -> Unit,
    action: @Composable () -> Unit
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
        action()
    }
}

@Preview
@Composable
private fun PreviewToolbar() {
    ThemedPreview {
        Toolbar(
            title = "Book Title",
            navigateUp = {},
            action = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Rounded.MoreVert,
                        contentDescription = "Actions"
                    )
                }
            }
        )
    }
}