package dev.jorgecastillo.composeconstraintlayout.ui

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.ImageAsset
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.layout.size
import androidx.ui.material.MaterialTheme
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import dev.jorgecastillo.composeconstraintlayout.movies.Tag
import dev.jorgecastillo.composeconstraintlayout.theme.lightThemeColors

@Composable
fun RoundedIconButton(
    tag: Tag,
    asset: ImageAsset,
    text: String,
    background: Color = lightThemeColors.primary
) {
    Column(
        modifier = Modifier.tag(tag) + Modifier.padding(16.dp),
        horizontalGravity = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.drawBackground(
                background,
                CircleShape
            ) + Modifier.padding(20.dp) + Modifier.size(26.dp),
            asset = asset
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            text = text
        )
    }
}

@Composable
fun RoundedIconButton(
    tag: Tag,
    asset: VectorAsset,
    text: String,
    background: Color = lightThemeColors.primary
) {
    Column(
        modifier = Modifier.tag(tag) + Modifier.padding(16.dp),
        horizontalGravity = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.drawBackground(
                background,
                CircleShape
            ) + Modifier.padding(20.dp),
            asset = asset
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            text = text
        )
    }
}

@Composable
fun RoundedTextButton(tag: Tag, text: String, subtext: String) {
    Column(
        modifier = Modifier.tag(tag) + Modifier.padding(16.dp),
        horizontalGravity = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.drawBackground(
                lightThemeColors.primary,
                CircleShape
            ) + Modifier.padding(20.dp),
            style = MaterialTheme.typography.h6,
            fontSize = 17.sp,
            color = Color.White,
            text = text
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            text = subtext
        )
    }
}
