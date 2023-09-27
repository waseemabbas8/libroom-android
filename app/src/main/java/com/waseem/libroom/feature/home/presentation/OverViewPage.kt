package com.waseem.libroom.feature.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.BookIcon
import com.waseem.libroom.core.compose.HeadPhonesIcon
import com.waseem.libroom.core.compose.SectionTitle
import com.waseem.libroom.core.ui.theme.LightColors


@Composable
fun OverViewPage(
    homeUiState: HomeUiState
) {
    Goals()
    RecentReads(recentReads = homeUiState.recentReads)
    Popular(popularBooks = homeUiState.popularBooks)
}

@Composable
private fun Goals() {
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(14.dp),
            progress = 0.25F,
            strokeWidth = 2.dp,
            trackColor = Color.LightGray,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stringResource(id = R.string.today_reading),
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "5 minutes left", style = MaterialTheme.typography.labelSmall.copy(color = LightColors.textGrey))
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding))) {
        Box(modifier = Modifier
            .weight(1f)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = LightColors.tertiaryContainer)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                HeadPhonesIcon(modifier = Modifier.padding(bottom = 16.dp))
                Text(text = "8.4", style = MaterialTheme.typography.headlineSmall)
                Text(text = stringResource(id = R.string.listened_hours))
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(modifier = Modifier
            .weight(1f)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = colorResource(id = R.color.green_200))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                BookIcon(modifier = Modifier.padding(bottom = 16.dp))
                Text(text = "8.4", style = MaterialTheme.typography.headlineSmall)
                Text(text = stringResource(id = R.string.pages_read))
            }
        }
    }
}

@Composable
private fun RecentReads(
    recentReads: List<BooksListUiState>
) {
    SectionTitle(
        title = stringResource(id = R.string.recent_reads),
        modifier = Modifier.padding(
            bottom = dimensionResource(id = R.dimen.section_title_margin_bottom)
        )
    ) {
        //TODO: implement view all callback
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(recentReads.size) {
            val book = recentReads[it]
            Column(
                modifier = Modifier.width(150.dp)
            ) {
                AsyncImage(
                    model = book.cover,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(MaterialTheme.shapes.small),
                    placeholder = painterResource(id = R.drawable.cover_placeholder)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = book.title, style = MaterialTheme.typography.titleMedium, maxLines = 1)
                Text(text = book.author, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
private fun Popular(
    popularBooks: List<BooksListUiState>
) {
    SectionTitle(
        title = stringResource(id = R.string.popular),
        modifier = Modifier.padding(
            bottom = dimensionResource(id = R.dimen.section_title_margin_bottom)
        )
    ) {
        //TODO: implement view all callback
    }
    LazyColumn(
        modifier = Modifier.height(200.dp),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(popularBooks.size) {
            val book = popularBooks[it]
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = book.cover,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(MaterialTheme.shapes.small),
                    placeholder = painterResource(id = R.drawable.cover_placeholder)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = book.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = "By ${book.author}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}