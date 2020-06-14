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

sealed class Tag
private object HeaderImageTag : Tag()
private object PortraitImageTag : Tag()
private object TitleTag : Tag()
private object SubtitleTag : Tag()
private object ButtonRentTag : Tag()
private object ButtonBuyTag : Tag()
private object ButtonsDividerTag : Tag()
private object RatingCircleTag : Tag()
private object FamilyCircleTag : Tag()
private object TomatoesCircleTag : Tag()
private object SimilarCircleTag : Tag()
private object ButtonsBottomDividerTag : Tag()
private object DescriptionTag : Tag()

@Composable
fun GooglePlayScreen(movie: MovieViewState) {
  VerticalScroller {
    ConstraintLayout(
      modifier = Modifier.drawBackground(color = Color.White) +
        Modifier.fillMaxWidth() +
        Modifier.fillMaxHeight(),
      constraintSet = ConstraintSet {
        val headerImage = tag(HeaderImageTag).apply {
          top constrainTo parent.top
          left constrainTo parent.left
          right constrainTo parent.right
        }

        val portraitImage = tag(PortraitImageTag).apply {
          left constrainTo parent.left
          top constrainTo headerImage.bottom
          bottom constrainTo headerImage.bottom
        }

        val title = tag(TitleTag).apply {
          top constrainTo headerImage.bottom
          left constrainTo portraitImage.right
          right constrainTo parent.right
          width = spread
        }

        val subtitle = tag(SubtitleTag).apply {
          top constrainTo title.bottom
          left constrainTo title.left
          right constrainTo parent.right
          width = spread
        }

        val buttonRent = tag(ButtonRentTag)
        val buttonBuy = tag(ButtonBuyTag)

        buttonBuy.apply {
          left constrainTo buttonRent.right
          top constrainTo subtitle.bottom
          right constrainTo parent.right
          width = spread
        }

        buttonRent.apply {
          left constrainTo parent.left
          top constrainTo subtitle.bottom
          right constrainTo buttonBuy.left
          width = spread
        }

        val buttonsDivider = tag(ButtonsDividerTag).apply {
          top constrainTo buttonBuy.bottom
          left constrainTo parent.left
          right constrainTo parent.right
        }

        val ratingCircle = tag(RatingCircleTag)
        val familyCircle = tag(FamilyCircleTag)
        val tomatoesCircle = tag(TomatoesCircleTag)
        val similarCircle = tag(SimilarCircleTag)

        ratingCircle.apply {
          top constrainTo buttonsDivider.bottom
          left constrainTo buttonsDivider.left
          right constrainTo familyCircle.left
        }

        familyCircle.apply {
          top constrainTo buttonsDivider.bottom
          left constrainTo ratingCircle.right
          right constrainTo tomatoesCircle.left
        }

        tomatoesCircle.apply {
          top constrainTo buttonsDivider.bottom
          left constrainTo familyCircle.right
          right constrainTo similarCircle.left
        }

        similarCircle.apply {
          top constrainTo buttonsDivider.bottom
          left constrainTo tomatoesCircle.right
          right constrainTo buttonsDivider.right
        }

        val buttonsBottomDivider = tag(ButtonsBottomDividerTag).apply {
          top constrainTo ratingCircle.bottom
          left constrainTo parent.left
          right constrainTo parent.right
        }

        tag(DescriptionTag).apply {
          top constrainTo buttonsBottomDivider.bottom
          left constrainTo parent.left
          right constrainTo parent.right
        }
      }) {
      CoilImage(
        data = movie.headerImageUrl,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth() +
          Modifier.preferredHeight(240.dp) +
          Modifier.tag(HeaderImageTag)
      )

      CoilImage(
        data = movie.portraitUrl,
        modifier = Modifier.preferredSize(120.dp, 260.dp) +
          Modifier.padding(8.dp) +
          Modifier.tag(PortraitImageTag)
      )

      Text(
        movie.name,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(top = 16.dp) + Modifier.tag(TitleTag)
      )

      Text(
        movie.subtitle,
        color = Color.Gray,
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.padding(top = 8.dp) + Modifier.tag(SubtitleTag)
      )

      Button(
        onClick = {},
        modifier = Modifier.padding(
          start = 16.dp,
          top = 16.dp,
          end = 8.dp
        ) + Modifier.tag(ButtonRentTag)
      ) {
        Text(text = "RENT FROM $${movie.rentingPrice}")
      }

      Button(
        onClick = {},
        modifier = Modifier.padding(
          start = 8.dp,
          top = 16.dp,
          end = 16.dp
        ) + Modifier.tag(ButtonBuyTag)
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
        ) + Modifier.tag(ButtonsDividerTag)
      )

      RoundedTextButton(
        tag = RatingCircleTag,
        text = movie.averageRating.toString(),
        subtext = "${movie.totalRatings} ratings"
      )

      RoundedIconButton(
        tag = FamilyCircleTag,
        asset = vectorResource(R.drawable.ic_family),
        text = "Family"
      )

      RoundedIconButton(
        tag = TomatoesCircleTag,
        asset = imageResource(R.drawable.tomato),
        text = "${movie.rottenTomatoesRating}%",
        background = Color(0xFFFFFAC2)
      )

      RoundedIconButton(
        tag = SimilarCircleTag,
        asset = vectorResource(R.drawable.ic_similar),
        text = "Similar"
      )

      Divider(
        color = Color.LightGray,
        modifier = Modifier.padding(
          top = 16.dp,
          start = 16.dp,
          end = 16.dp
        ) + Modifier.tag(ButtonsBottomDividerTag)
      )

      Text(
        movie.description,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(all = 16.dp) + Modifier.tag(DescriptionTag)
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
