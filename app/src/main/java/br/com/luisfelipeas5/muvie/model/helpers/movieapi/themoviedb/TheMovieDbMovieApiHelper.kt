package br.com.luisfelipeas5.muvie.model.helpers.movieapi.themoviedb

import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.luisfelipeas5.muvie.model.helpers.movieapi.MovieApiHelper
import io.reactivex.Single

class TheMovieDbMovieApiHelper(private val theMovieDbService: TheMovieDbService) : MovieApiHelper {

    override fun getMovies(page: Int): Single<List<Movie>> {
        return theMovieDbService.getMovies(page)
                .map {getMoviesResponse -> getMoviesResponse.movies }
    }

    override fun getMovie(movieId: String?): Single<Movie> = theMovieDbService.getMovie(movieId).cast(Movie::class.java)

}
