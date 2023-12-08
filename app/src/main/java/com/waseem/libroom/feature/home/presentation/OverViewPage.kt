package com.waseem.libroom.feature.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gowtham.ratingbar.ComposeStars
import com.gowtham.ratingbar.RatingBarStyle
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.ElevatedTile
import com.waseem.libroom.core.compose.SectionTitle
import com.waseem.libroom.feature.book.presentation.compose.BookThumbnail


@Composable
fun OverViewPage(
    homeUiState: HomeUiState,
    onBookItemClick: (bookId: String) -> Unit
) {
    ContinueReading()
    RecentReads(recentReads = homeUiState.recentReads, onBookItemClick = onBookItemClick)
    Popular(popularBooks = homeUiState.popularBooks)
}

@Composable
fun ContinueReading() {
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProgressIndicator(
            progress = { 0.25F },
            modifier = Modifier.size(14.dp),
            strokeWidth = 2.dp,
            trackColor = Color.LightGray,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stringResource(id = R.string.today_reading),
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "5 minutes left", style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.outline))
    }
    Spacer(modifier = Modifier.height(20.dp))
    ElevatedTile(
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding))
            .clickable { /*TODO*/ }
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://covers.openlibrary.org/b/id/505653-M.jpg",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(75.dp)
                    .height(110.dp)
                    .clip(MaterialTheme.shapes.small),
                placeholder = painterResource(id = R.drawable.cover_placeholder)
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.horizontal_screen_padding)))
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = "The Subtle Art of Not Giving",
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1
                )
                Text(
                    text = "By Mark Manson",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ComposeStars(
                        value = 4.5f,
                        size = 16.dp,
                        spaceBetween = 2.dp,
                        style = RatingBarStyle.Fill(),
                        painterEmpty = painterResource(id = R.drawable.ic_star_empty),
                        painterFilled = painterResource(id = R.drawable.ic_star_filled),
                        hideInactiveStars = false,
                        numOfStars = 5
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "4.5", style = MaterialTheme.typography.labelMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "(55 reviews)", style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outline))
                }
                LinearProgressIndicator(
                    progress = { 0.25f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun RecentReads(
    recentReads: List<BooksListUiState>,
    onBookItemClick: (bookId: String) -> Unit
) {
    SectionTitle(
        title = stringResource(id = R.string.recommended),
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        //TODO: implement view all callback
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(recentReads.size) {
            val book = recentReads[it]
            BookItem(book = book, onBookItemClick = onBookItemClick)
        }
    }
}

@Composable
private fun Popular(
    popularBooks: List<BooksListUiState>
) {
    SectionTitle(
        title = stringResource(id = R.string.popular),
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        //TODO: implement view all callback
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(popularBooks.size) {
            val book = popularBooks[it]
            BookItem(book = book, onBookItemClick = { /*TODO*/ })
        }
    }
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.bottom_screen_margin)))
}

@Composable
private fun BookItem(book: BooksListUiState, onBookItemClick: (bookId: String) -> Unit) {
    Column(
        modifier = Modifier
            .width(109.dp)
            .clickable {
                onBookItemClick(book.id)
            }
    ) {
        BookThumbnail(
            url = book.cover,
            modifier = Modifier.fillMaxWidth().height(160.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = book.title, style = MaterialTheme.typography.labelLarge, maxLines = 1)
        Text(
            text = book.author, style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.outline,
                fontWeight = FontWeight.Medium
            ),
            maxLines = 1
        )
    }
}