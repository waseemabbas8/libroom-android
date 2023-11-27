package com.waseem.libroom.feature.reader.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.BookMarkIcon
import com.waseem.libroom.core.compose.HeadPhonesIcon
import com.waseem.libroom.core.compose.LightModeOutlinedIcon
import com.waseem.libroom.core.compose.TextFormatIcon
import com.waseem.libroom.core.compose.TonalButton
import com.waseem.libroom.core.compose.Toolbar
import com.waseem.libroom.core.compose.defaultIconTint
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun BookReaderScreen(
    navigateUp: () -> Unit
) {

    Column {
        Toolbar(title = "Chapter 1", navigateUp = navigateUp) {
            TonalButton(
                onClick = { },
                modifier = Modifier
                    .widthIn(min = 32.dp)
                    .padding(end = dimensionResource(id = R.dimen.horizontal_screen_padding)),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                BookMarkIcon()
            }
        }
        ChapterBody()
        LinearProgressIndicator(
            progress = { 0.25f },
            modifier = Modifier.fillMaxWidth()
        )
        BottomBar()
    }
}

@Composable
private fun ColumnScope.ChapterBody() {
    Text(
        text = "Chapter 1\nThe Siege of Kemp's House",
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding))
    )
    Text(
        text = stringResource(id = R.string.lorem_text),
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .weight(1f)
            .padding(top = dimensionResource(id = R.dimen.vertical_screen_margin))
            .padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding))
    )
}

@Composable
private fun BottomBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {  }) {
            HeadPhonesIcon(
                modifier = Modifier.size(24.dp),
                tint = defaultIconTint()
            )
        }
        IconButton(onClick = {  }) {
            LightModeOutlinedIcon()
        }
        Text(
            text = "250 of 1000", style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.widthIn(min = 100.dp),
            textAlign = TextAlign.Center,
        )
        IconButton(onClick = {  }) {
            TextFormatIcon()
        }
        Text(
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.horizontal_screen_padding)),
            text = "25%", style = MaterialTheme.typography.titleMedium
        )

    }
}

@Preview
@Composable
private fun PreviewBookReader() {
    ThemedPreview {
        BookReaderScreen(navigateUp = {})
    }
}