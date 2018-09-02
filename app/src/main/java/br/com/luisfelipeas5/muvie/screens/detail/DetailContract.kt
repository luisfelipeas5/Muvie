package br.com.luisfelipeas5.muvie.screens.detail

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.mvpbase.contract.Contract
import io.reactivex.Single

interface DetailContract: Contract {

    interface View: Contract.View {
        fun onLoadingMovie(loading: Boolean)
        fun onMovieReady(movie: Movie)
        fun onLoadMovieFailed(throwable: Throwable)
        fun getMovieId(): String
    }

    interface Presenter: Contract.Presenter<View> {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun loadDetail()
    }

    interface Interactor: Contract.Interactor {
        fun getDetail(movieId: String?): Single<Movie>
    }

}