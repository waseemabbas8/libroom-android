package com.waseem.libroom.feature.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waseem.libroom.R
import com.waseem.libroom.core.compose.FilledButton
import com.waseem.libroom.core.compose.ScreenTitle
import com.waseem.libroom.core.ui.ThemedPreview

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = dimensionResource(id = R.dimen.horizontal_screen_padding)
            )
    ) {
        ScreenTitle(
            title = stringResource(id = R.string.profile)
        )
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.section_title_margin_bottom)))
        Row {
            Box(
                modifier = Modifier
                    .size(85.dp)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.inversePrimary,
                        shape = CircleShape
                    )
                    .padding(2.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dummy_profile),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp)
                        .clip(CircleShape),
                )
            }
            Column {
                Text(
                    text = "Audrey Ava", style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Text(
                    text = "your@email.com", style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 10.dp)
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Edit Profile")
                }
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
        )
        Spacer(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.section_title_margin_bottom)))

        FilledButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Logout"
        ) {

        }
    }
}

@Preview
@Composable
private fun previewHome() {
    ThemedPreview {
        ProfileScreen()
    }
}