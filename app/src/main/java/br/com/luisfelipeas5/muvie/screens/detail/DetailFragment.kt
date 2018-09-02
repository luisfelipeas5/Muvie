package br.com.luisfelipeas5.muvie.screens.detail

import android.view.View
import br.com.luisfelipeas5.muvie.R
import br.com.luisfelipeas5.muvie.androidview.BaseFragment
import br.com.luisfelipeas5.muvie.di.components.BaseComponent
import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.luisfelipeas5.muvie.screens.detail.di.DetailModule
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailFragment: BaseFragment(), DetailContract.View {

    override fun onInitInject(component: BaseComponent) = component.module(DetailModule()).inject(this)

    override fun getLayoutResource(): Int = R.layout.fragment_detail

    override fun onInitView() {
    }

    @Inject
    fun setPresenter(presenter: DetailContract.Presenter) {
        presenter.attach(this)
    }

    override fun onLoadingMovie(loading: Boolean) {
        pbLoadingMovie.visibility = if (loading) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onMovieReady(movie: Movie) {
        tvMovie.text  = movie.getName()
    }

    override fun onLoadMovieFailed(throwable: Throwable) {
        showShortToast(throwable, R.string.load_movie_failed)
    }

    override fun getMovieId(): String = DetailFragmentArgs.fromBundle(arguments).movieId

}