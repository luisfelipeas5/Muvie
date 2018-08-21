package br.com.luisfelipeas5.muvie.screens.movies

import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.madeinlabs.mvpbase.schedulerprovider.SchedulerProvider
import br.com.mvpbase.contract.BasePresenter
import io.reactivex.rxkotlin.subscribeBy

class MoviesPresenter(private val schedulerProvider: SchedulerProvider,
                      private val interactor: MoviesContract.Interactor) : BasePresenter<MoviesContract.View>(), MoviesContract.Presenter {

    private var mNextPage: Int = 1

    private var mLoadingMovies: Boolean = false
    set(loading) {
        mView?.onLoadingMovies(loading)
    }

    override fun loadMovies() {
        if (mLoadingMovies) {
            return
        }

        mLoadingMovies = true
        val getMoviesDisposable = interactor.getMovies(mNextPage)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                        onSuccess = { onMoviesReady(it) },
                        onError = { onGetMoviesFailed(it) }
                )
        addDisposable(getMoviesDisposable)
    }

    private fun onMoviesReady(movies: List<Movie>) {
        mLoadingMovies = false
        mNextPage++
        mView?.onNewMoviesReady(movies)
    }

    private fun onGetMoviesFailed(throwable: Throwable) {
        mLoadingMovies = false
        throwable.printStackTrace()
    }

}