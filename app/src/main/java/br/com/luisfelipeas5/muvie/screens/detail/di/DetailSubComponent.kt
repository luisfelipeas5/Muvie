package br.com.luisfelipeas5.muvie.screens.detail.di

import br.com.luisfelipeas5.muvie.screens.detail.DetailFragment
import dagger.Subcomponent

@Subcomponent(modules = [(DetailModule::class)])
interface DetailSubComponent {
    fun inject(detailFragment: DetailFragment)
}