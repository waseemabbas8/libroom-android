package com.waseem.libroom.feature.search.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.ScreenTitle
import com.waseem.libroom.core.compose.SearchBox
import com.waseem.libroom.core.compose.SectionTitle
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun SearchScreen() {
    Scaffold {
        val columnCount = 2
        LazyVerticalGrid(
            columns = GridCells.Fixed(columnCount),
            modifier = Modifier.padding(it),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(
                bottom = dimensionResource(id = R.dimen.bottom_screen_margin)
            )
        ) {
            item(span = { GridItemSpan(columnCount) }) {
                Column {
                    ScreenTitle(
                        title = stringResource(id = R.string.search),
                        modifier = Modifier.padding(
                            horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding)
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SearchBox(modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding)))
                    Authors()
                    SectionTitle(
                        title = stringResource(id = R.string.top_categories),
                        modifier = Modifier.padding(bottom = 12.dp)
                    ) {
                        //TODO: implement view all callback
                    }
                }
            }

            items(6) { index ->

                val paddingEnd: Dp
                val paddingStart: Dp

                if (index % columnCount == 0) {
                    paddingStart = dimensionResource(id = R.dimen.horizontal_screen_padding)
                    paddingEnd = 0.dp
                } else {
                    paddingStart = 0.dp
                    paddingEnd = dimensionResource(id = R.dimen.horizontal_screen_padding)
                }

                Box(
                    modifier = Modifier.padding(start = paddingStart, end = paddingEnd)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.book_cover),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(1.6f)
                            .clip(MaterialTheme.shapes.small)
                    )
                    Text(
                        text = "Travel",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.BottomStart),
                        style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                    )
                }
            }
        }
    }
}

@Composable
private fun Authors() {
    SectionTitle(
        title = stringResource(id = R.string.top_authors),
        modifier = Modifier.padding(
            bottom = dimensionResource(id = R.dimen.section_title_margin_bottom)
        )
    ) {
        //TODO: implement view all callback
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.horizontal_screen_padding)),
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding)),
    ) {
        items(6) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.book_cover),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(MaterialTheme.shapes.small),
                )
                Text(
                    text = "E. James",
                    style = MaterialTheme.typography.bodyMedium.copy(Color.Black),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHome() {
    ThemedPreview {
        SearchScreen()
    }
}