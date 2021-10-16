package pe.gugadev.moviesapp.repository

import com.google.gson.GsonBuilder
import retrofit2.http.GET
import pe.gugadev.moviesapp.application.AppConstants
import pe.gugadev.moviesapp.data.model.MoviesResult
import pe.gugadev.moviesapp.data.remote.MoviesDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface WebService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): MoviesResult
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey: String): MoviesResult
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MoviesResult
}

object RetrofitClient {
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}