package br.com.luisfelipeas5.muvie.screens.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.luisfelipeas5.muvie.R
import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.adapter_movies.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private val mMovies = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adapter_movies, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mMovies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = mMovies[position]
        val name = movie.getName()
        holder.tvName.text = name

        val context = holder.itemView.context
        holder.ivCover.contentDescription = context.getString(R.string.movie_cover_content_description, name)

        val cover = movie.getSmallCover()
        Glide.with(holder.itemView)
                .load(cover)
                .apply(RequestOptions.centerCropTransform())
                .into(holder.ivCover)
    }

    fun addAll(newMovies: List<Movie>) {
        val oldMovies = mutableListOf<Movie>()
        oldMovies.addAll(mMovies)

        mMovies.addAll(newMovies)

        val moviesDiffUtilCallback = MoviesDiffUtilCallback(oldMovies, mMovies)
        DiffUtil.calculateDiff(moviesDiffUtilCallback).dispatchUpdatesTo(this)
    }

    inner class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer

}
