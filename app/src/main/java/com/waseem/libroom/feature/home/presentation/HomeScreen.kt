package com.waseem.libroom.feature.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.ErrorUi
import com.waseem.libroom.core.compose.ScreenTitle
import com.waseem.libroom.core.compose.SizzleTab
import com.waseem.libroom.core.compose.TabIndicator
import com.waseem.libroom.core.mvi.collectState

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val state by viewModel.collectState()

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it)
        ) {
            ScreenTitle(
                title = stringResource(id = R.string.discover_books),
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding)
                )
            )
            when(state) {
                HomeState.DefaultState -> {}
                HomeState.LoadingState -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                HomeState.ErrorState -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        ErrorUi {
                            viewModel.action(HomeAction.Load)
                        }
                    }
                }
                is HomeState.HomeContentState -> {
                    OverViewPage(homeUiState = (state as HomeState.HomeContentState).uiState)
                }
            }
        }
    }
}

@Composable
private fun HomeTabs(state: HomeState.HomeContentState) {
    val tabIndex = remember { mutableIntStateOf(0) }

    val titles = listOf("Overview", "Business", "Design", "Economics")

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
        OverViewPage(homeUiState = state.uiState)
    }
}