package pe.gugadev.moviesapp.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import pe.gugadev.moviesapp.R
import pe.gugadev.moviesapp.core.Result
import pe.gugadev.moviesapp.data.model.Movie
import pe.gugadev.moviesapp.data.remote.MoviesDataSource
import pe.gugadev.moviesapp.databinding.FragmentMoviesBinding
import pe.gugadev.moviesapp.presentation.MoviesViewModel
import pe.gugadev.moviesapp.presentation.MoviesViewModelFactory
import pe.gugadev.moviesapp.repository.MoviesRepositoryImpl
import pe.gugadev.moviesapp.repository.RetrofitClient
import pe.gugadev.moviesapp.ui.movies.adapter.MovieAdapter
import pe.gugadev.moviesapp.ui.movies.adapter.concat.PopularConcatAdapter
import pe.gugadev.moviesapp.ui.movies.adapter.concat.TopRatedConcatAdapter
import pe.gugadev.moviesapp.ui.movies.adapter.concat.UpcomingConcatAdapter

class MoviesFragment : Fragment(R.layout.fragment_movies), MovieAdapter.OnMovieClickListener {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var adapter: ConcatAdapter
    private val viewModel by viewModels<MoviesViewModel> {
        MoviesViewModelFactory(
            MoviesRepositoryImpl(
                MoviesDataSource(RetrofitClient.webService)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesBinding.bind(view)
        adapter = ConcatAdapter()
        getMovies()
    }

    private fun getMovies() {
        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE

                    val upcomingMovies = result.data.first.results
                    val topRatedMovies = result.data.second.results
                    val popularMovies = result.data.third.results

                    adapter.apply {
                        addAdapter(0, UpcomingConcatAdapter(MovieAdapter(upcomingMovies, this@MoviesFragment)))
                        addAdapter(1, TopRatedConcatAdapter(MovieAdapter(topRatedMovies, this@MoviesFragment)))
                        addAdapter(2, PopularConcatAdapter(MovieAdapter(popularMovies, this@MoviesFragment)))
                    }

                    binding.rvMovies.adapter = adapter
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.w("[liveData]", "Failure -> ${result.exception}")
                }
            }
        });
    }

    override fun onMovieClick(movie: Movie) {
        Log.d("onMovieClick", movie.toString())
    }
}