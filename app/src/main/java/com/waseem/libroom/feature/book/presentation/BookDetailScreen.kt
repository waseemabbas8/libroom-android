package com.waseem.libroom.feature.book.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.BookMarkIcon
import com.waseem.libroom.core.compose.FilledButton
import com.waseem.libroom.core.compose.TonalButton
import com.waseem.libroom.core.compose.Toolbar

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
            title = "Book Title",
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
            Stats()
            Synopsis(openReader = openReader)
        }
    }
}

@Composable
private fun BookCover() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.align(alignment = Alignment.BottomEnd)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(155.dp)
                    .padding(dimensionResource(id = R.dimen.horizontal_screen_padding))
            ) {
                Text(
                    text = "The River Devil And the Herry Potter",
                    maxLines = 2,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(fraction = 0.5f),
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = "By Diane Whiteside",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(fraction = 0.5f),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.60f)
                    )
                )
                Text(
                    text = "November 24, 2015",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(fraction = 0.5f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        AsyncImage(
            model = "https://covers.openlibrary.org/b/id/505653-M.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(120.dp)
                .height(170.dp)
                .padding(end = 16.dp, bottom = 16.dp)
                .clip(MaterialTheme.shapes.small)
                .align(alignment = Alignment.TopEnd),
            placeholder = painterResource(id = R.drawable.cover_placeholder)
        )
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
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
        )
    }
    val divider = @Composable {
        Text(text = "|", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }

    Row(
        modifier = Modifier
            .padding(top = dimensionResource(id = R.dimen.vertical_screen_margin))
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.surfaceVariant)
            .padding(vertical = dimensionResource(id = R.dimen.horizontal_screen_padding)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Rating",
                modifier = Modifier.size(18.dp),
                tint = MaterialTheme.colorScheme.primary,
            )
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