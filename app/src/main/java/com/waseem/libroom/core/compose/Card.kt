package com.waseem.libroom.core.compose

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import com.waseem.libroom.R

/***
We use ElevatedTile to display an [ElevatedCard]
 */
@Composable
fun ElevatedTile(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    elevation: CardElevation = CardDefaults.elevatedCardElevation(defaultElevation = dimensionResource(id = R.dimen.card_elevation)),
    colors: CardColors = CardDefaults.cardColors(
        containerColor = Color.White
    ),
    content: @Composable ColumnScope.() -> Unit,
) {
    ElevatedCard(
        modifier = modifier,
        colors = colors,
        shape = shape,
        elevation = elevation,
        content = content,
    )
}