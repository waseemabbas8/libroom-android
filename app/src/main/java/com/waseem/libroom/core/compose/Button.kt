package com.waseem.libroom.core.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun FilledButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) = Button(
    modifier = modifier,
    shape = MaterialTheme.shapes.small,
    onClick = onClick
) {
    Text(text = text)
}

@Composable
fun TonalButton(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) = FilledTonalButton(
    modifier = modifier,
    contentPadding = contentPadding,
    shape = MaterialTheme.shapes.small,
    onClick = onClick
) {
    content()
}

@Composable
fun FilledNetworkButton(
    modifier: Modifier = Modifier,
    text: String,
    loading: Boolean,
    loadingText: String = "Please wait...",
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(18.dp),
                    color = Color.White,
                    strokeWidth = 2.5.dp
                )
                Spacer(modifier = Modifier.widthIn(min = 8.dp))
                Text(text = loadingText)
            } else {
                Text(text = text)
            }
        }
    }
}

@Preview
@Composable
private fun previewButtons() {
    ThemedPreview {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.horizontal_screen_padding)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FilledButton(text = "Filled Button") {

            }
            TonalButton(onClick = {  }) {
                Text(text = "Filled Tonal Button")
            }
            TonalButton(
                onClick = {  },
                modifier = Modifier.widthIn(min = 32.dp),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                BookMarkIcon()
            }
            FilledNetworkButton(
                modifier = Modifier.width(200.dp),
                text = "Login", loading = true,
            ) {

            }
        }
    }
}