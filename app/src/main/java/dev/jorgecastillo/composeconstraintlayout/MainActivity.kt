package dev.jorgecastillo.composeconstraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import dev.jorgecastillo.composeconstraintlayout.domain.aMovie
import dev.jorgecastillo.composeconstraintlayout.movies.GooglePlayScreen
import dev.jorgecastillo.composeconstraintlayout.theme.lightThemeColors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colors = lightThemeColors) {
                GooglePlayScreen(aMovie())
            }
        }
    }
}


