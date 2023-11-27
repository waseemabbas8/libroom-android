package com.waseem.libroom.core.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.theme.LightColors

@Composable
fun ScreenTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title, style = MaterialTheme.typography.displaySmall,
        modifier = modifier
    )
}

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier,
    onViewAllClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.horizontal_screen_padding),
                top = dimensionResource(id = R.dimen.section_title_margin_top)
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        TextButton(onClick = onViewAllClick) {
            Text(
                text = stringResource(id = R.string.view_all),
                style = MaterialTheme.typography.titleMedium.copy(color = LightColors.textGrey)
            )
        }
    }
}