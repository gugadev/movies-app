package pe.gugadev.moviesapp.repository

import pe.gugadev.moviesapp.data.model.MoviesResult
import pe.gugadev.moviesapp.data.remote.MoviesDataSource

class MoviesRepositoryImpl(private val dataSource: MoviesDataSource) : MoviesRepository {
    override suspend fun getUpcomingMovies(): MoviesResult = dataSource.getUpcomingMovies()

    override suspend fun getTopRatedMovies(): MoviesResult = dataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MoviesResult = dataSource.getPopularMovies()
}