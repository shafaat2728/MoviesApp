package com.digitify.moviesapp.data.dto

data class MoviesModel(
    var results: List<Movies>? = emptyList()
)

data class Movies(
    var id: Int,
    var poster_path: String? = "",
    var release_date: String? = "",
    var title: String? = ""
)

data class MovieDetail(
    var backdrop_path: String? = "",
    var id: Int,
    var overview: String? = "",
    var popularity: Double? = 0.0,
    var poster_path: String? = "",
    var release_date: String? = "",
    var genres: List<Genres>? = emptyList(),
    var revenue: Int? = 0,
    var runtime: Int? = 0,
    var title: String? = "",
    var vote_average: Double? = 0.0,
    var vote_count: Int? = 0
)

data class Genres(
    var id: Int,
    var name: String? = ""
)