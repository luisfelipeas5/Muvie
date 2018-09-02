package br.com.luisfelipeas5.muvie.screens.movies

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.luisfelipeas5.muvie.R
import br.com.luisfelipeas5.muvie.model.domain.movie.Movie
import br.com.luisfelipeas5.muvie.screens.movies.adapter.MoviesAdapter
import br.com.luisfelipeas5.muvie.androidview.BaseFragment
import br.com.luisfelipeas5.muvie.androidview.EndlessRecyclerViewScrollListener
import br.com.luisfelipeas5.muvie.di.components.BaseComponent
import br.com.luisfelipeas5.muvie.screens.detail.DetailFragmentArgs
import br.com.luisfelipeas5.muvie.screens.movies.di.MoviesModule
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MoviesFragment: BaseFragment(), MoviesContract.View, MoviesAdapter.Listener {

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
        val linearLayoutManager = LinearLayoutManager(context)
        rvMovies.layoutManager = linearLayoutManager

        val moviesAdapter = MoviesAdapter()
        moviesAdapter.mListener = this
        rvMovies.adapter = moviesAdapter

        rvMovies.addOnScrollListener(object: EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                mPresenter.loadMovies()
            }
        })
    }

    override fun onNewMoviesReady(movies: List<Movie>) {
        val moviesAdapter = rvMovies.adapter as MoviesAdapter
        moviesAdapter.addAll(movies)
    }

    override fun onLoadingMovies(loading: Boolean) {
        pbLoadingMovies.visibility = if (loading) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onMovieClicked(movie: Movie) {
        mPresenter.onMovieClicked(movie)
    }

    override fun showDetailScreen(movieId: String) {
        val args = DetailFragmentArgs.Builder(movieId)
                .build()
                .toBundle()
        root.findNavController().navigate(R.id.detailFragment, args)
    }

}