package pe.gugadev.moviesapp.repository

import pe.gugadev.moviesapp.data.model.MoviesResult

interface MoviesRepository {
    suspend fun getUpcomingMovies(): MoviesResult
    suspend fun getTopRatedMovies(): MoviesResult
    suspend fun getPopularMovies(): MoviesResult
}