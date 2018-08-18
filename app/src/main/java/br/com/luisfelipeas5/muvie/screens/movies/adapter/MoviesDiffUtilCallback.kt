package br.com.luisfelipeas5.muvie.screens.movies.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.luisfelipeas5.muvie.model.domain.movie.Movie

class MoviesDiffUtilCallback(private val oldMovies: List<Movie>,
                             private val newMovies: MutableList<Movie>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldMovies.size

    override fun getNewListSize(): Int = newMovies.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMovie = oldMovies[oldItemPosition]
        val newMovie = newMovies[newItemPosition]
        return oldMovie.getId() == newMovie.getId()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMovie = oldMovies[oldItemPosition]
        val newMovie = newMovies[newItemPosition]
        return oldMovie.getName() == newMovie.getName()
    }

}
