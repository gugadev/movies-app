package pe.gugadev.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import pe.gugadev.moviesapp.core.Result
import pe.gugadev.moviesapp.repository.MoviesRepository
import java.lang.Exception

class MoviesViewModel(private val repository: MoviesRepository): ViewModel() {
    fun fetchMainScreenMovies() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(
                Triple(repository.getUpcomingMovies(), repository.getTopRatedMovies(), repository.getPopularMovies())
            ))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

    fun fetchUpcomingMovies() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repository.getUpcomingMovies()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

    fun fetchTopRatedMovies() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repository.getTopRatedMovies()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

    fun fetchPopularMovies() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repository.getPopularMovies()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}

class MoviesViewModelFactory(private val repository: MoviesRepository) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MoviesRepository::class.java).newInstance(repository)
    }
}