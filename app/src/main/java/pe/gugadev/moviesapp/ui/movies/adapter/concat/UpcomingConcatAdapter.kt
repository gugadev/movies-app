package pe.gugadev.moviesapp.ui.movies.adapter.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.gugadev.moviesapp.core.BaseConcatHolder
import pe.gugadev.moviesapp.databinding.UpcomingMovieRowBinding
import pe.gugadev.moviesapp.ui.movies.adapter.MovieAdapter

class UpcomingConcatAdapter(private val adapter: MovieAdapter) : RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = UpcomingMovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder) {
            is ConcatViewHolder -> holder.bind(adapter)
        }
    }

    override fun getItemCount(): Int  = 1 /* Siempre uno porque es un solo adapter */

    private inner class ConcatViewHolder(val binding: UpcomingMovieRowBinding): BaseConcatHolder<MovieAdapter>(binding.root) {
        override fun bind(adapter: MovieAdapter) {
            binding.rvUpcomingMovies.adapter = adapter
        }
    }
}