package br.com.luisfelipeas5.muvie.screens.movies

import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.madeinlabs.mvpbase.schedulerprovider.SchedulerProvider
import br.com.mvpbase.contract.BasePresenter
import io.reactivex.rxkotlin.subscribeBy

class MoviesPresenter(private val schedulerProvider: SchedulerProvider,
                      private val interactor: MoviesContract.Interactor) : BasePresenter<MoviesContract.View>(), MoviesContract.Presenter {

    override fun loadMovies() {
        val getMoviesDisposable = interactor.getMovies()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                        onSuccess = { onMoviesReady(it) },
                        onError = { onGetMoviesFailed(it) }
                )
        addDisposable(getMoviesDisposable)
    }

    private fun onMoviesReady(movies: List<Movie>) {
        mView?.onNewMoviesReady(movies)
    }

    private fun onGetMoviesFailed(throwable: Throwable) {
        throwable.printStackTrace()
    }

}