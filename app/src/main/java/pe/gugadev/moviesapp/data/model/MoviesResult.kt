package pe.gugadev.moviesapp.data.model

data class MoviesResult(val status: Int = 200, val results: List<Movie> = listOf())