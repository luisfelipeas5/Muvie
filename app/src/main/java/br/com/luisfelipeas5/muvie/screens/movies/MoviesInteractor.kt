package br.com.luisfelipeas5.muvie.screens.movies

import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.luisfelipeas5.muvie.model.helpers.movieapi.MovieApiHelper
import io.reactivex.Single

class MoviesInteractor(private val movieApiHelper: MovieApiHelper) : MoviesContract.Interactor {

    override fun getMovies(page: Int): Single<List<Movie>> {
        return movieApiHelper.getMovies(page)
    }

}
