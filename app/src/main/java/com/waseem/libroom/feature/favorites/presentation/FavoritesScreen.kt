package com.waseem.libroom.feature.favorites.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.MenuIcon
import com.waseem.libroom.core.compose.ScreenTitle
import com.waseem.libroom.core.compose.SearchBox
import com.waseem.libroom.core.compose.SortingIcon
import com.waseem.libroom.core.ui.ThemedPreview
import com.waseem.libroom.core.ui.theme.LightColors

@Composable
fun FavoritesScreen() {
    Scaffold {
        val columnCount = 3
        LazyVerticalGrid(
            columns = GridCells.Fixed(columnCount),
            modifier = Modifier.padding(it),
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
            items(6) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.book_cover),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(0.7f)
                            .clip(MaterialTheme.shapes.small),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Animal Farm", style = MaterialTheme.typography.titleMedium)
                    Text(
                        text = "George Orwell",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
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
        SortingIcon()
        Text(
            text = stringResource(id = R.string.recently_read),
            modifier = Modifier.padding(start = 8.dp).weight(1f),
            style = MaterialTheme.typography.titleMedium.copy(LightColors.textGrey)
        )
        MenuIcon ()
    }
}

@Preview
@Composable
private fun previewHome() {
    ThemedPreview {
        FavoritesScreen()
    }
}