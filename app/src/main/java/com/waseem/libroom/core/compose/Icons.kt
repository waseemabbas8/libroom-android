package com.waseem.libroom.core.compose

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun defaultIconTint() = Color.Gray

@Composable
fun HomeIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_home),
        contentDescription = stringResource(id = R.string.home),
        modifier = modifier
    )
}

@Composable
fun SearchIcon(
    modifier: Modifier = Modifier,
    tint: Color = defaultIconTint()
) {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
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
        imageVector = Icons.Rounded.FavoriteBorder,
        contentDescription = stringResource(id = R.string.favorites),
        tint = tint,
        modifier = modifier
    )
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = Icons.Outlined.Person,
        contentDescription = stringResource(id = R.string.profile),
        modifier = modifier
    )
}

@Composable
fun ArrowBackIcon(
    modifier: Modifier = Modifier,
    tint: Color = defaultIconTint()
) {
    Icon(
        imageVector = Icons.Rounded.ArrowBack,
        contentDescription = stringResource(id = R.string.arrow_back),
        tint = tint,
        modifier = modifier
    )
}

@Composable
fun HeadPhonesIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_headphones),
        contentDescription = stringResource(id = R.string.arrow_back),
        modifier = modifier
    )
}

@Composable
fun BookIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_book),
        contentDescription = stringResource(id = R.string.arrow_back),
        modifier = modifier
    )
}

@Composable
fun ImportExportIcon(
    modifier: Modifier = Modifier,
    tint: Color = defaultIconTint()
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_import_export),
        contentDescription = "",
        tint = tint,
        modifier = modifier
    )
}

@Composable
fun SortIcon(
    modifier: Modifier = Modifier,
    tint: Color = defaultIconTint()
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_sort),
        contentDescription = "",
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
            ImportExportIcon()
            SortIcon()
        }
    }
}

