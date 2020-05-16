package dev.jorgecastillo.composeconstraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.core.tag
import androidx.ui.foundation.Box
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBackground
import androidx.ui.graphics.Color
import androidx.ui.layout.ConstraintLayout
import androidx.ui.layout.ConstraintSet
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.preferredWidth
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                GooglePlayScreen(aMovie())
            }
        }
    }
}

fun aMovie() = MovieViewState(
    headerImageUrl = "https://img.cinemablend.com/filter:scale/quill/8/7/2/8/6/c/87286c6017ecd384d246c6517493e65d5c3c4b3d.jpg?fw=1200",
    portraitUrl = "https://m.media-amazon.com/images/M/MV5BMjQ2ODIyMjY4MF5BMl5BanBnXkFtZTgwNzY4ODI2NzM@._V1_.jpg",
    name = "Aladdin",
    subtitle = "May 8, 2019",
    rentingPrice = 4.99f,
    buyingPrice = 9.99f,
    averageRating = 7.2f,
    rottenTomatoesRating = 71,
    description = "A kind-hearted street urchin and a power-hungry Grand Vizier vie for a magic lamp that has the power to make their deepest wishes come true."
)

@Composable
fun GooglePlayScreen(movie: MovieViewState) {
    ConstraintLayout(
        modifier = Modifier.drawBackground(color = Color.White),
        constraintSet = ConstraintSet {
            val headerImage = tag("headerImage")
            val portraitImage = tag("portraitImage")

            headerImage.top constrainTo parent.top
            headerImage.left constrainTo parent.left
            headerImage.right constrainTo parent.right

            portraitImage.left constrainTo parent.left
            portraitImage.top constrainTo headerImage.bottom
            portraitImage.bottom constrainTo headerImage.bottom

//            divider.top constrainTo parent.top
//            divider.bottom constrainTo parent.bottom
//            divider.left constrainTo parent.left
//            divider.right constrainTo parent.right
//            text2.top constrainTo divider.top
//            text2.bottom constrainTo divider.bottom
//            text2.verticalBias = 0.2f
//
//            text1.width = wrap
//            text1.height = wrapFixed
//            divider.width = valueFixed(1.dp)
//            divider.height = spread
        }) {
        Image(movie.headerImageUrl)
        Text(
            (0 until 100).fold("") { text, value -> "$text$value " },
            Modifier.tag("text1")
        )
        Text("Short text", Modifier.tag("text2"))
        Box(
            modifier = Modifier.tag("divider").preferredWidth(1.dp).fillMaxHeight(),
            backgroundColor = Color.Green
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        GooglePlayScreen(aMovie())
    }
}
