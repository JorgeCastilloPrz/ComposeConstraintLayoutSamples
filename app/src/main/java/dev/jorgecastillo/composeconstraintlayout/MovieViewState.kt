package dev.jorgecastillo.composeconstraintlayout

data class MovieViewState(
    val headerImageUrl: String,
    val portraitUrl: String,
    val name: String,
    val subtitle: String,
    val rentingPrice: Float,
    val buyingPrice: Float,
    val averageRating: Float,
    val rottenTomatoesRating: Int,
    val description: String
)
