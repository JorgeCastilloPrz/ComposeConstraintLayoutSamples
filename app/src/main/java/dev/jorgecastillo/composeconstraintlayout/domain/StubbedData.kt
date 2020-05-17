package dev.jorgecastillo.composeconstraintlayout.domain

import dev.jorgecastillo.composeconstraintlayout.movies.MovieViewState

fun aMovie() = MovieViewState(
    headerImageUrl = "https://img.cinemablend.com/quill/8/7/2/8/6/c/87286c6017ecd384d246c6517493e65d5c3c4b3d.jpg",
    portraitUrl = "https://m.media-amazon.com/images/M/MV5BMjQ2ODIyMjY4MF5BMl5BanBnXkFtZTgwNzY4ODI2NzM@._V1_.jpg",
    name = "Aladdin (2019)",
    subtitle = "May 8, 2019",
    rentingPrice = 4.99f,
    buyingPrice = 9.99f,
    averageRating = 7.2f,
    rottenTomatoesRating = 71,
    description = "A kind-hearted street urchin and a power-hungry Grand Vizier vie for a magic lamp that has the power to make their deepest wishes come true."
)
