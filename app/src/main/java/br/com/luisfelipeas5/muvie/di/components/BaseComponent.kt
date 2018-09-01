package br.com.luisfelipeas5.muvie.di.components

import br.com.luisfelipeas5.muvie.screens.detail.di.DetailModule
import br.com.luisfelipeas5.muvie.screens.detail.di.DetailSubComponent
import br.com.luisfelipeas5.muvie.screens.movies.di.MoviesModule
import br.com.luisfelipeas5.muvie.screens.movies.di.MoviesSubComponent

interface BaseComponent {
    fun module(moviesModule: MoviesModule): MoviesSubComponent
    fun module(moviesModule: DetailModule): DetailSubComponent
}
