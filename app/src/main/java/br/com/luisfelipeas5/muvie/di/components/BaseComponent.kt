package br.com.luisfelipeas5.muvie.di.components

import br.com.luisfelipeas5.muvie.screens.movies.di.MoviesModule
import br.com.luisfelipeas5.muvie.screens.movies.di.MoviesSubComponent

interface BaseComponent {
    fun module(moviesModule: MoviesModule): MoviesSubComponent
}
