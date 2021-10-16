package pe.gugadev.moviesapp.data.model

import com.google.gson.annotations.SerializedName

// Un data class no necesita llaves 🤓
data class Movie (
    val id: Int = -1,
    @SerializedName("genre_ids")
    val genres: List<Int> = listOf(),
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("original_language")
    val originalLanguage: String = "",
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    val popularity: Double = 0.0,
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int = -1,
    val adult: Boolean = false,
    val title: String = "",
    val video: Boolean = false,
    val overview: String = "",

)

