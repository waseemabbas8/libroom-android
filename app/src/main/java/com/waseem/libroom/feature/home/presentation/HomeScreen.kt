package com.waseem.libroom.feature.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.ThemedPreview
import com.waseem.libroom.core.ui.theme.LightColors

@Composable
fun HomeScreen() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Discover Books", style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
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
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(25.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(5) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Overview", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(4.dp))
                //TODO: change logic with selected tab
                if(it == 0) {
                    Divider(
                        thickness = 3.dp,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.width(30.dp)
                    )
                }
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
                    Text(text = "Already Enough. A Path to Self Control", style = MaterialTheme.typography.titleMedium)
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