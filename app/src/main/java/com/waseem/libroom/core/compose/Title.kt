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
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.ui.theme.LightColors

@Composable
fun ScreenTitle(
    title: String
) {
    Text(
        text = title, style = MaterialTheme.typography.displaySmall,
        modifier = Modifier.padding(
            horizontal = dimensionResource(id = (R.dimen.horizontal_screen_padding))
        )
    )
}

@Composable
fun SectionTitle(
    title: String,
    onViewAllClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        TextButton(onClick = onViewAllClick) {
            Text(
                text = "View All",
                style = MaterialTheme.typography.titleMedium.copy(color = LightColors.textGrey)
            )
        }
    }
}