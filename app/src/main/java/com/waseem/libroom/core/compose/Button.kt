package com.waseem.libroom.core.compose

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilledButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) = Button(
    modifier = modifier,
    shape = RoundedCornerShape(8.dp),
    onClick = onClick
) {
    Text(text = text)
}