package com.waseem.libroom.feature.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.SizzleTab
import com.waseem.libroom.core.compose.TabIndicator
import com.waseem.libroom.core.ui.ThemedPreview
import com.waseem.libroom.core.ui.theme.LightColors

@Composable
fun HomeScreen() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it)
        ) {
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Discover Books", style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            HomeTabs()
            Spacer(modifier = Modifier.height(35.dp))
            RecentReads()
            Spacer(modifier = Modifier.height(35.dp))
            Popular()
        }
    }
}

@Composable
private fun HomeTabs() {
    val tabIndex = remember { mutableIntStateOf(0) }

    val titles = listOf("Overview", "Business", "Design", "Economics")

    Column {
        ScrollableTabRow(
            selectedTabIndex = tabIndex.intValue,
            edgePadding = 16.dp,
            divider = {},
            indicator = { tabPositions ->
                TabIndicator(tabPositions = tabPositions, tabIndex = tabIndex.intValue)
            },
        ) {
            titles.forEachIndexed { index, title ->
                SizzleTab(
                    title = title,
                    selected = tabIndex.intValue == index,
                    onClick = { tabIndex.intValue = index }
                )
            }
        }
    }
}

@Composable
private fun RecentReads() {
    Text(
        text = "Recently read", style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(20.dp))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(4) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.book_cover),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(150.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(10.dp)),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Animal Farm", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "by George Orwell",
                    style = MaterialTheme.typography.bodyLarge.copy(color = LightColors.textGrey)
                )
            }
        }
    }
}

@Composable
private fun Popular() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(text = "Popular", style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "View All", style = MaterialTheme.typography.bodyLarge.copy(
                color = LightColors.textGrey,
                fontWeight = FontWeight.SemiBold,
            )
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    LazyColumn(
        modifier = Modifier.height(200.dp),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(3) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.book_cover),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(8.dp)),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Already Enough. A Path to Self Control",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "by Lisa Olivera",
                        style = MaterialTheme.typography.bodyLarge.copy(color = LightColors.textGrey)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun previewHome() {
    ThemedPreview {
        HomeScreen()
    }
}