package pe.gugadev.moviesapp.data.remote

import pe.gugadev.moviesapp.application.AppConstants
import pe.gugadev.moviesapp.data.model.MoviesResult
import pe.gugadev.moviesapp.repository.WebService

class MoviesDataSource(private val webService: WebService) {
    suspend fun getUpcomingMovies(): MoviesResult = webService.getUpcomingMovies(AppConstants.TOKEN)

    suspend fun getTopRatedMovies(): MoviesResult = webService.getTopRatedMovies(AppConstants.TOKEN)

    suspend fun getPopularMovies(): MoviesResult = webService.getPopularMovies(AppConstants.TOKEN)
}