package br.com.luisfelipeas5.muvie.screens.movies.di

import br.com.luisfelipeas5.muvie.screens.movies.MoviesFragment
import dagger.Subcomponent

@Subcomponent(modules = [(MoviesModule::class)])
abstract class MoviesSubComponent {
    abstract fun inject(moviesFragment: MoviesFragment)
}
