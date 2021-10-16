package pe.gugadev.moviesapp.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.gugadev.moviesapp.core.BaseViewHolder
import pe.gugadev.moviesapp.data.model.Movie
import pe.gugadev.moviesapp.databinding.MovieItemBinding

class MovieAdapter(private val movies: List<Movie>, private val itemClickListener: OnMovieClickListener) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun onMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        val holder = MoviesViewHolder(itemBinding/*, parent.context */)
        /**
         * This is used to get the index (position) of the element
         * inside a RecyclerView to get the Movie instance from it
         */
        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            } ?: return@setOnClickListener
            itemClickListener.onMovieClick(movies[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is MoviesViewHolder -> {
                holder.bind(movies[position])
            }
        }
    }

    override fun getItemCount(): Int = movies.size

    private inner class MoviesViewHolder(val binding: MovieItemBinding/*, val context: Context */): BaseViewHolder<Movie>(binding.root) {
        override fun bind(item: Movie) {
            Glide.with(binding.root).load("https://image.tmdb.org/t/p/w500${item.posterPath}").centerCrop().into(binding.moviePoster)
        }
    }
}