package pe.gugadev.moviesapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import pe.gugadev.moviesapp.R
import pe.gugadev.moviesapp.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {
    private lateinit var binding: FragmentMovieDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailsBinding.bind(view)
    }
}