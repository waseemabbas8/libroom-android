package com.waseem.libroom.feature.book.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.BookMarkIcon
import com.waseem.libroom.core.compose.Chip
import com.waseem.libroom.core.compose.FilledButton
import com.waseem.libroom.core.compose.OutlinedTile
import com.waseem.libroom.core.compose.StarIcon
import com.waseem.libroom.core.compose.TonalButton
import com.waseem.libroom.core.compose.Toolbar
import com.waseem.libroom.feature.book.presentation.compose.BookThumbnail

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BookDetailScreen(
    navigateUp: () -> Unit,
    openReader: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val showBottomSheet = remember { mutableStateOf(false) }

    if (showBottomSheet.value) {
        ChaptersBottomSheet(showBottomSheet = showBottomSheet, coroutineScope = scope)
    }

    Column {
        //using custom toolbar instead of Scaffold topBar because of the extra top padding
        Toolbar(
            title = "Book Summary",
            navigateUp = navigateUp,
        ) {
            IconButton(onClick = { showBottomSheet.value = true }) {
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = "Actions"
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding))
        ) {
            BookCover()
            FlowRow(
                modifier = Modifier.padding(top = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Chip(text = "Romance")
                Chip(text = "Fiction")
                Chip(text = "Fantasy")
                Chip(text = "Adventure")
                Chip(text = "Novel")
            }
            Stats()
            Synopsis(openReader = openReader)
        }
    }
}

@Composable
private fun BookCover() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        BookThumbnail(
            url = "https://covers.openlibrary.org/b/id/11238165-L.jpg",
            modifier = Modifier
                .width(112.dp)
                .height(165.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .padding(start = dimensionResource(id = R.dimen.horizontal_screen_padding))
        ) {
            Text(
                text = "The River Devil and Herry Potter",
                maxLines = 2,
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "By Diane Whiteside",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.60f)
                )
            )
            Text(
                text = "November 24, 2015",
                modifier = Modifier.padding(bottom = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "14 of 340 pages (60%)",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.labelMedium
            )
            LinearProgressIndicator(
                progress = { 0.25f },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
private fun Stats() {
    val valueText = @Composable { value: String ->
        Text(text = value, style = MaterialTheme.typography.titleMedium)
    }
    val label = @Composable { label: String ->
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.outline
        )
    }
    val divider = @Composable {
        Text(text = "|", color = MaterialTheme.colorScheme.outline)
    }

    OutlinedTile(
        modifier = Modifier
            .padding(top = dimensionResource(id = R.dimen.vertical_screen_margin)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.horizontal_screen_padding)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                StarIcon(modifier = Modifier.size(18.dp))
                valueText(" 4.8")
                label("/5")
            }
            divider()
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                valueText("5.2k")
                label("Reads")
            }
            divider()
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                valueText("340")
                label("Pages")
            }
        }
    }


}

@Composable
private fun ColumnScope.Synopsis(
    openReader: () -> Unit
) {
    Text(
        text = stringResource(id = R.string.synopsis),
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(
            top = dimensionResource(id = R.dimen.section_title_margin_bottom),
            bottom = dimensionResource(id = R.dimen.bottom_screen_margin)
        )
    )
    BottomGradientText(text = stringResource(id = R.string.lorem_text))
    Row {
        TonalButton(
            onClick = {  },
            modifier = Modifier
                .widthIn(min = 32.dp)
                .padding(end = 8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            BookMarkIcon()
        }
        FilledButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Continue Reading",
            onClick = openReader,
        )
    }
}

@Composable
private fun ColumnScope.BottomGradientText(
    text: String
) {
    Box(modifier = Modifier.weight(1f)) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.60f)
            )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
                            MaterialTheme.colorScheme.surface
                        ),
                        startY = 250.0f,
                    )
                )
        )
    }
}