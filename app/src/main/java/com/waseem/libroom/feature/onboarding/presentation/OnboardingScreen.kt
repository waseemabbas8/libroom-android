package com.waseem.libroom.feature.onboarding.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.CircledLogo
import com.waseem.libroom.core.compose.FilledButton
import com.waseem.libroom.core.mvi.collectEvents
import com.waseem.libroom.core.mvi.collectState
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    gotoAuth: () -> Unit
) {
    val state by viewModel.collectState()

    viewModel.collectEvents {
        when (it) {
            OnboardingEvent.GotoAuth -> gotoAuth()
        }
    }

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.onboarding_padding)),
        ) {

            //draw circle with stoke
            CircledLogo()

            Pager(state = state)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = { viewModel.action(OnboardingAction.OnSkip) },
                    shape = MaterialTheme.shapes.small,
                ) {
                    Text(
                        text = stringResource(id = R.string.skip),
                    )
                }
                val text = if (state.uiState.currentStep == state.uiState.pages.lastIndex) {
                    stringResource(id = R.string.get_started)
                } else {
                    stringResource(id = R.string.next)
                }
                FilledButton(
                    modifier = Modifier.animateContentSize(),
                    text = text,
                    onClick = { viewModel.action(OnboardingAction.OnNext) },
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ColumnScope.Pager(state: OnboardingState) {
    val pagerState = rememberPagerState(pageCount = {
        state.uiState.pages.size
    })

    LaunchedEffect(key1 = state.uiState.currentStep) {
        pagerState.animateScrollToPage(state.uiState.currentStep)
    }

    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        state = pagerState,
        userScrollEnabled = false,
    ) { page ->
        val pageUiState = state.uiState.pages[page]
        Column(
            modifier = Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = pageUiState.image),
                contentDescription = "onboard image"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.section_title_margin_top)),
                textAlign = TextAlign.Center,
                text = pageUiState.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.section_title_margin_top)),
                textAlign = TextAlign.Center,
                text = pageUiState.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .weight(0.25f),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(12.dp)
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4_XL)
@Composable
private fun Preview() {
    ThemedPreview {
        OnboardingScreen(viewModel = hiltViewModel(), gotoAuth = {})
    }
}