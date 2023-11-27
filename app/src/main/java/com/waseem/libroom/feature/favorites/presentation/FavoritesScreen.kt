package com.waseem.libroom.feature.favorites.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.ImportExportIcon
import com.waseem.libroom.core.compose.ScreenTitle
import com.waseem.libroom.core.compose.SearchBox
import com.waseem.libroom.core.compose.SortIcon
import com.waseem.libroom.core.mvi.collectState
import com.waseem.libroom.core.ui.ThemedPreview
import com.waseem.libroom.core.ui.theme.LightColors
import com.waseem.libroom.feature.home.presentation.BooksListUiState

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel
) {
    val state by viewModel.collectState()

    val columnCount = 3
    LazyVerticalGrid(
        columns = GridCells.Fixed(columnCount),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(
            start = dimensionResource(id = R.dimen.horizontal_screen_padding),
            end = dimensionResource(id = R.dimen.horizontal_screen_padding),
            bottom = dimensionResource(id = R.dimen.bottom_screen_margin)
        )
    ) {
        item(span = { GridItemSpan(columnCount) }) {
            Column {
                ScreenTitle(title = stringResource(id = R.string.my_bookshelf))
                SearchBox(
                    modifier = Modifier.padding(
                        top = 8.dp,
                        bottom = dimensionResource(id = R.dimen.section_title_margin_top)
                    )
                )
                SortingView()
            }
        }
        when(state) {
            FavoritesState.DefaultState -> {}
            FavoritesState.ErrorState -> {}
            is FavoritesState.FavoriteBooksState -> {
                booksGrid((state as FavoritesState.FavoriteBooksState).uiState.favoriteBooks)
            }
            FavoritesState.LoadingState -> {
                item { CircularProgressIndicator() }
            }
        }
    }
}

@Composable
private fun SortingView() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        ImportExportIcon()
        Text(
            text = stringResource(id = R.string.recently_read),
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.titleMedium.copy(LightColors.textGrey)
        )
        IconButton(onClick = { /*TODO*/ }) {
            SortIcon()
        }

    }
}

private fun LazyGridScope.booksGrid(favoriteBooks: List<BooksListUiState>) {
    items(favoriteBooks.size) {
        val book = favoriteBooks[it]
        Column {
            AsyncImage(
                model = book.cover,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(0.7f)
                    .clip(MaterialTheme.shapes.small),
                placeholder = painterResource(id = R.drawable.cover_placeholder)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = book.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1
            )
            Text(
                text = book.author,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
private fun PreviewHome() {
    ThemedPreview {
        FavoritesScreen(viewModel = viewModel())
    }
}