package br.com.luisfelipeas5.muvie.screens.detail

import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.madeinlabs.mvpbase.schedulerprovider.SchedulerProvider
import br.com.mvpbase.contract.BasePresenter
import io.reactivex.rxkotlin.subscribeBy

class DetailPresenter(private val schedulerProvider: SchedulerProvider, private val interactor: DetailContract.Interactor) : BasePresenter<DetailContract.View>(), DetailContract.Presenter {

    override fun loadDetail() {
        mView?.onLoadingMovie(true)

        val movieId = mView?.getMovieId()
        val getDetailSingle = interactor.getDetail(movieId)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(
                        onSuccess = { onMovieReady(it) },
                        onError = { onLoadMovieFailed(it) }
                )
        addDisposable(getDetailSingle)
    }

    private fun onLoadMovieFailed(throwable: Throwable) {
        mView?.onLoadMovieFailed(throwable)
        mView?.onLoadingMovie(false)
    }

    private fun onMovieReady(movie: Movie) {
        mView?.onMovieReady(movie)
        mView?.onLoadingMovie(false)
    }
}