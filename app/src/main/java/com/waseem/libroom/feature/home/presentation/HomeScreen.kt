package com.waseem.libroom.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.ScreenTitle
import com.waseem.libroom.core.compose.SizzleTab
import com.waseem.libroom.core.compose.TabIndicator
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun HomeScreen() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it)
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.vertical_screen_margin)))
            ScreenTitle(title = stringResource(id = R.string.discover_books))
            HomeTabs()
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
        if (tabIndex.intValue == 0) {
            OverViewPage()
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