package br.com.luisfelipeas5.muvie.screens.detail

import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.luisfelipeas5.muvie.model.helpers.movieapi.MovieApiHelper
import io.reactivex.Single

class DetailInteractor(private val movieApiHelper: MovieApiHelper) : DetailContract.Interactor {

    override fun getDetail(movieId: String?): Single<Movie> = movieApiHelper.getMovie(movieId)

}