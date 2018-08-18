package br.com.luisfelipeas5.muvie.screens.movies.di

import br.com.luisfelipeas5.muvie.model.helpers.movieapi.MovieApiHelper
import br.com.luisfelipeas5.muvie.screens.movies.MoviesContract
import br.com.luisfelipeas5.muvie.screens.movies.MoviesInteractor
import br.com.luisfelipeas5.muvie.screens.movies.MoviesPresenter
import br.com.madeinlabs.mvpbase.schedulerprovider.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MoviesModule {

    @Provides
    fun providesPresenter(schedulerProvider: SchedulerProvider,
                          interactor: MoviesContract.Interactor): MoviesContract.Presenter {
        return MoviesPresenter(schedulerProvider, interactor)
    }

    @Provides
    fun providesInteractor(movieApiHelper: MovieApiHelper): MoviesContract.Interactor {
        return MoviesInteractor(movieApiHelper)
    }

}
