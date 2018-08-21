package br.com.luisfelipeas5.muvie.screens.movies

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.mvpbase.contract.Contract
import io.reactivex.Single

interface MoviesContract: Contract {
    interface View: Contract.View {
        fun onNewMoviesReady(movies: List<Movie>)
        fun onLoadingMovies(loading: Boolean)
    }

    interface Presenter: Contract.Presenter<View> {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun loadMovies()
    }

    interface Interactor: Contract.Interactor {
        fun getMovies(page: Int): Single<List<Movie>>
    }
}
