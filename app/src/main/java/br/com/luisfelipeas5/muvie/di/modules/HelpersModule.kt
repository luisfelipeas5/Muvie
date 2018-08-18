package br.com.luisfelipeas5.muvie.di.modules

import android.content.Context
import br.com.luisfelipeas5.muvie.model.helpers.movieapi.MovieApiHelper
import br.com.luisfelipeas5.muvie.model.helpers.movieapi.themoviedb.TheMovieDbMovieApiHelper
import br.com.luisfelipeas5.muvie.model.helpers.movieapi.themoviedb.TheMovieDbService
import dagger.Module
import dagger.Provides

@Module
class HelpersModule(context: Context) {

    private val theMovieDbService = TheMovieDbService.Factory.build(context.applicationContext)

    @Provides
    fun providesMovieApiHelper(): MovieApiHelper {
        return TheMovieDbMovieApiHelper(theMovieDbService)
    }

}