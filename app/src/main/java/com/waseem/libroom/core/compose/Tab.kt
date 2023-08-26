package com.waseem.libroom.core.compose

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.dp
import com.waseem.libroom.core.ui.theme.LightColors

@Composable
fun SizzleTab(
    selected: Boolean,
    onClick: () -> Unit,
    title: String,
) {
    Tab(
        text = { Text(title) },
        selected = selected,
        selectedContentColor = Color.Black,
        unselectedContentColor = LightColors.textGrey,
        onClick = onClick
    )
}

@Composable
fun TabIndicator(tabPositions: List<TabPosition>, tabIndex: Int) {
    TabRowDefaults.SecondaryIndicator(
        modifier = Modifier.customTabIndicatorOffset(
            currentTabPosition = tabPositions[tabIndex]
        )
    )
}

@Composable
private fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width - 32.dp,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left + 16.dp,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset, y = (-8).dp)
        .width(currentTabWidth)
}