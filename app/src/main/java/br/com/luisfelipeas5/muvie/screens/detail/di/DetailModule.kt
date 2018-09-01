package br.com.luisfelipeas5.muvie.screens.detail.di

import br.com.luisfelipeas5.muvie.model.helpers.movieapi.MovieApiHelper
import br.com.luisfelipeas5.muvie.screens.detail.DetailContract
import br.com.luisfelipeas5.muvie.screens.detail.DetailInteractor
import br.com.luisfelipeas5.muvie.screens.detail.DetailPresenter
import br.com.madeinlabs.mvpbase.schedulerprovider.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class DetailModule {

    @Provides
    fun providesPresenter(schedulerProvider: SchedulerProvider,
                                interactor: DetailInteractor): DetailContract.Presenter {
        return DetailPresenter(schedulerProvider, interactor)
    }

    @Provides
    fun providesInteractor(movieApiHelper: MovieApiHelper): DetailContract.Interactor {
        return DetailInteractor(movieApiHelper)
    }

}