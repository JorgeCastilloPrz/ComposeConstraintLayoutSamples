package dev.jorgecastillo.composeconstraintlayout.movies

data class MovieViewState(
    val headerImageUrl: String,
    val portraitUrl: String,
    val name: String,
    val subtitle: String,
    val rentingPrice: Float,
    val buyingPrice: Float,
    val averageRating: Float,
    val totalRatings: Int,
    val rottenTomatoesRating: Int,
    val description: String
)
