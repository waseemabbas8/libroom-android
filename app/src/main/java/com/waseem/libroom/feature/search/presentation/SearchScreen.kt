package com.waseem.libroom.feature.search.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.ScreenTitle
import com.waseem.libroom.core.compose.SectionTitle
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun SearchScreen() {
    Scaffold {
        val columnCount = 2
        LazyVerticalGrid(
            columns = GridCells.Fixed(columnCount),
            modifier = Modifier.padding(it),
        ) {
            item(span = { GridItemSpan(columnCount) }) {
                Column {
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.vertical_screen_margin)))
                    ScreenTitle(title = stringResource(id = R.string.search))
                    Spacer(modifier = Modifier.height(8.dp))

                    val text = rememberSaveable { mutableStateOf("") }
                    TextField(
                        value = text.value,
                        onValueChange = { newValue: String -> text.value = newValue },
                        singleLine = true,
                        shape = MaterialTheme.shapes.small,
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedContainerColor = colorResource(id = R.color.text_filed_background),
                            unfocusedContainerColor = colorResource(id = R.color.text_filed_background)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding)),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = ""
                            )
                        },
                    )
                    SectionTitle(title = stringResource(id = R.string.top_authors)) {
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
                    SectionTitle(title = stringResource(id = R.string.top_categories)) {
                        //TODO: implement view all callback
                    }
                }
            }

            val itemCount = 6

            items(itemCount) { index ->
                val paddingTop = if (index < columnCount) 0.dp else 4.dp
                val paddingBottom =
                    if (index < itemCount - 2) 4.dp else dimensionResource(id = R.dimen.bottom_screen_margin)
                val paddingStart =
                    if (index % columnCount == 0) dimensionResource(id = R.dimen.horizontal_screen_padding) else 4.dp
                val paddingEnd =
                    if (index % columnCount == 0) 4.dp else dimensionResource(id = R.dimen.horizontal_screen_padding)

                Box(
                    modifier = Modifier.padding(
                        start = paddingStart,
                        end = paddingEnd,
                        top = paddingTop,
                        bottom = paddingBottom
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.book_cover),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.aspectRatio(1.6f).clip(MaterialTheme.shapes.small)
                    )
                    Text(
                        text = "Travel",
                        modifier = Modifier.padding(16.dp).align(Alignment.BottomStart),
                        style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                    )
                }
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