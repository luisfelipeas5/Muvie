package br.com.luisfelipeas5.muvie.screens.movies

import androidx.recyclerview.widget.LinearLayoutManager
import br.com.luisfelipeas5.muvie.R
import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.luisfelipeas5.muvie.screens.movies.adapter.MoviesAdapter
import br.com.luisfelipeas5.muvie.androidview.BaseFragment
import br.com.luisfelipeas5.muvie.di.components.BaseComponent
import br.com.luisfelipeas5.muvie.screens.movies.di.MoviesModule
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MoviesFragment: BaseFragment(), MoviesContract.View {

    private lateinit var mPresenter: MoviesContract.Presenter

    override fun onInitInject(component: BaseComponent) {
        val moviesModule = MoviesModule()
        component.module(moviesModule).inject(this)
    }

    @Inject
    fun setPresenter(presenter: MoviesContract.Presenter) {
        mPresenter = presenter
        presenter.attach(this)
    }

    override fun getLayoutResource(): Int = R.layout.fragment_movies

    override fun onInitView() {
        rvMovies.layoutManager = LinearLayoutManager(context)
        rvMovies.adapter = MoviesAdapter()
    }

    override fun onNewMoviesReady(movies: List<Movie>) {
        val moviesAdapter = rvMovies.adapter as MoviesAdapter
        moviesAdapter.addAll(movies)
    }

}