package dev.jorgecastillo.composeconstraintlayout.movies

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.drawBackground
import androidx.ui.graphics.Color
import androidx.ui.layout.ConstraintLayout
import androidx.ui.layout.ConstraintSet
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.layout.preferredHeight
import androidx.ui.layout.preferredSize
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.jorgecastillo.composeconstraintlayout.R
import dev.jorgecastillo.composeconstraintlayout.domain.aMovie
import dev.jorgecastillo.composeconstraintlayout.theme.lightThemeColors
import dev.jorgecastillo.composeconstraintlayout.ui.RoundedIconButton
import dev.jorgecastillo.composeconstraintlayout.ui.RoundedTextButton

@Composable
fun GooglePlayScreen(movie: MovieViewState) {
    VerticalScroller {
        ConstraintLayout(
            modifier = Modifier.drawBackground(color = Color.White) +
                    Modifier.fillMaxWidth() +
                    Modifier.fillMaxHeight(),
            constraintSet = ConstraintSet {
                val headerImage = tag("headerImage")
                val portraitImage = tag("portraitImage")
                val title = tag("title")
                val subtitle = tag("subtitle")
                val buttonRent = tag("buttonRent")
                val buttonBuy = tag("buttonBuy")
                val buttonsDivider = tag("buttonsDivider")
                val ratingCircle = tag("ratingCircle")
                val familyCircle = tag("familyCircle")
                val tomatoesCircle = tag("tomatoesCircle")
                val similarCircle = tag("similarCircle")
                val buttonsBottomDivider = tag("buttonsBottomDivider")
                val description = tag("description")

                headerImage.top constrainTo parent.top
                headerImage.left constrainTo parent.left
                headerImage.right constrainTo parent.right

                portraitImage.left constrainTo parent.left
                portraitImage.top constrainTo headerImage.bottom
                portraitImage.bottom constrainTo headerImage.bottom

                title.top constrainTo headerImage.bottom
                title.left constrainTo portraitImage.right
                title.right constrainTo parent.right
                title.width = spread

                subtitle.top constrainTo title.bottom
                subtitle.left constrainTo title.left
                subtitle.right constrainTo parent.right
                subtitle.width = spread

                buttonRent.left constrainTo parent.left
                buttonRent.top constrainTo subtitle.bottom
                buttonRent.right constrainTo buttonBuy.left
                buttonRent.width = spread

                buttonBuy.left constrainTo buttonRent.right
                buttonBuy.top constrainTo subtitle.bottom
                buttonBuy.right constrainTo parent.right
                buttonBuy.width = spread

                buttonsDivider.top constrainTo buttonBuy.bottom
                buttonsDivider.left constrainTo parent.left
                buttonsDivider.right constrainTo parent.right

                ratingCircle.top constrainTo buttonsDivider.bottom
                ratingCircle.left constrainTo buttonsDivider.left
                ratingCircle.right constrainTo familyCircle.left

                familyCircle.top constrainTo buttonsDivider.bottom
                familyCircle.left constrainTo ratingCircle.right
                familyCircle.right constrainTo tomatoesCircle.left

                tomatoesCircle.top constrainTo buttonsDivider.bottom
                tomatoesCircle.left constrainTo familyCircle.right
                tomatoesCircle.right constrainTo similarCircle.left

                similarCircle.top constrainTo buttonsDivider.bottom
                similarCircle.left constrainTo tomatoesCircle.right
                similarCircle.right constrainTo buttonsDivider.right

                buttonsBottomDivider.top constrainTo ratingCircle.bottom
                buttonsBottomDivider.left constrainTo parent.left
                buttonsBottomDivider.right constrainTo parent.right

                description.top constrainTo buttonsBottomDivider.bottom
                description.left constrainTo parent.left
                description.right constrainTo parent.right
            }) {
            CoilImage(
                data = movie.headerImageUrl,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth() + Modifier.preferredHeight(240.dp) + Modifier.tag(
                    "headerImage"
                )
            )

            CoilImage(
                data = movie.portraitUrl,
                modifier = Modifier.preferredSize(120.dp, 260.dp) +
                        Modifier.padding(8.dp) +
                        Modifier.tag("portraitImage")
            )

            Text(
                movie.name,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(top = 16.dp) + Modifier.tag("title")
            )

            Text(
                movie.subtitle,
                color = Color.Gray,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(top = 8.dp) + Modifier.tag("subtitle")
            )

            Button(
                onClick = {},
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 8.dp
                ) + Modifier.tag("buttonRent")
            ) {
                Text(text = "RENT FROM $${movie.rentingPrice}")
            }

            Button(
                onClick = {},
                modifier = Modifier.padding(
                    start = 8.dp,
                    top = 16.dp,
                    end = 16.dp
                ) + Modifier.tag("buttonBuy")
            ) {
                Text(text = "BUY FROM $${movie.buyingPrice}")
            }

            Divider(
                color = Color.LightGray,
                modifier = Modifier.padding(
                    top = 32.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ) + Modifier.tag("buttonsDivider")
            )

            RoundedTextButton(
                tag = "ratingCircle",
                text = movie.averageRating.toString(),
                subtext = "${movie.totalRatings} ratings"
            )

            RoundedIconButton(
                tag = "familyCircle",
                asset = vectorResource(R.drawable.ic_family),
                text = "Family"
            )

            RoundedIconButton(
                tag = "tomatoesCircle",
                asset = imageResource(R.drawable.tomato),
                text = "${movie.rottenTomatoesRating}%",
                background = Color(0xFFFFFAC2)
            )

            RoundedIconButton(
                tag = "similarCircle",
                asset = vectorResource(R.drawable.ic_similar),
                text = "Similar"
            )

            Divider(
                color = Color.LightGray,
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ) + Modifier.tag("buttonsBottomDivider")
            )

            Text(
                movie.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(all = 16.dp) + Modifier.tag("description")
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme(colors = lightThemeColors) {
        GooglePlayScreen(aMovie())
    }
}
