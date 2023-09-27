package com.waseem.libroom.core.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun ErrorUi(
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.horizontal_screen_padding)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = null,
        )
        Text(
            text = stringResource(id = R.string.oops),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.bottom_screen_margin))
        )
        Text(
            text = stringResource(id = R.string.something_wrong),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.section_title_margin_bottom))
        )
        FilledButton(
            text = stringResource(id = R.string.try_again),
            onClick = onRetry,
        )
    }
}

@Preview
@Composable
private fun previewErrorUi() {
    ThemedPreview {
        ErrorUi{}
    }
}