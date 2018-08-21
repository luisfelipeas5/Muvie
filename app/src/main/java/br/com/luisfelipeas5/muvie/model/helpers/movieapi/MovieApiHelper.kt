package br.com.luisfelipeas5.muvie.model.helpers.movieapi

import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import io.reactivex.Single

interface MovieApiHelper {
    fun getMovies(page: Int = 1): Single<List<Movie>>
}