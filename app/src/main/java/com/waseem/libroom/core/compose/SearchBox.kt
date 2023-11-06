package com.waseem.libroom.core.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun SearchBox(
    modifier: Modifier = Modifier
) {
    val text = rememberSaveable { mutableStateOf("") }
    TextField(
        value = text.value,
        placeholder = { Text(text = stringResource(id = R.string.search_box_placeholder)) },
        onValueChange = { newValue: String -> text.value = newValue },
        singleLine = true,
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = modifier.fillMaxWidth(),
        leadingIcon = { SearchIcon() }
    )
}

@Preview
@Composable
private fun PreviewSearchBox() {
    ThemedPreview {
        SearchBox()
    }
}