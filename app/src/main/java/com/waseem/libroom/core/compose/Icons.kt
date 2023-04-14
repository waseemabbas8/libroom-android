package com.waseem.libroom.core.compose

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun defaultIconTint() = Color.Gray

@Composable
fun HomeIcon(
    modifier: Modifier = Modifier,
    tint: Color = defaultIconTint()
) {
    Icon(
        imageVector = Icons.Outlined.Home,
        contentDescription = stringResource(id = R.string.home),
        tint = tint,
        modifier = modifier
    )
}

@Composable
fun SearchIcon(
    modifier: Modifier = Modifier,
    tint: Color = defaultIconTint()
) {
    Icon(
        imageVector = Icons.Outlined.Search,
        contentDescription = stringResource(id = R.string.search),
        tint = tint,
        modifier = modifier
    )
}

@Composable
fun FavoriteIcon(
    modifier: Modifier = Modifier,
    tint: Color = defaultIconTint()
) {
    Icon(
        imageVector = Icons.Outlined.Favorite,
        contentDescription = stringResource(id = R.string.favorites),
        tint = tint,
        modifier = modifier
    )
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    tint: Color = defaultIconTint()
) {
    Icon(
        imageVector = Icons.Outlined.Person,
        contentDescription = stringResource(id = R.string.profile),
        tint = tint,
        modifier = modifier
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun previewIcons() {
    ThemedPreview {
        FlowRow {
            HomeIcon()
            SearchIcon()
            FavoriteIcon()
            ProfileIcon()
        }
    }
}

