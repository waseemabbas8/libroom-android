package com.waseem.libroom.feature.book.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.TonalButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChaptersBottomSheet(
    showBottomSheet: MutableState<Boolean>,
    coroutineScope: CoroutineScope,
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = {
            showBottomSheet.value = false
        },
        sheetState = sheetState,
        windowInsets = WindowInsets(0.dp)
    ) {
        // Sheet content
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.horizontal_screen_padding)),
                text = stringResource(id = R.string.chapters),
                style = MaterialTheme.typography.titleLarge
            )
            IconButton(onClick = {
                coroutineScope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet.value = false
                    }
                }
            }) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Close"
                )
            }
        }

        val items = listOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
        )

        //chapters grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(
                horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding),
                vertical = dimensionResource(id = R.dimen.bottom_screen_margin),
            )
        ) {
            items(items) { item ->
                TonalButton(
                    modifier = Modifier.widthIn(min = 32.dp),
                    contentPadding = PaddingValues(vertical = 16.dp, horizontal = 4.dp),
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "$item", style = MaterialTheme.typography.titleLarge)
                }
            }
        }
        Text(
            text = stringResource(id = R.string.tap_chapter),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(
                top = dimensionResource(id = R.dimen.bottom_screen_margin),
                bottom = BottomSheetDefaults.windowInsets.asPaddingValues().calculateBottomPadding() + dimensionResource(id = R.dimen.bottom_screen_margin),
                start = dimensionResource(id = R.dimen.horizontal_screen_padding),
                end = dimensionResource(id = R.dimen.horizontal_screen_padding)
            )
        )
    }
}