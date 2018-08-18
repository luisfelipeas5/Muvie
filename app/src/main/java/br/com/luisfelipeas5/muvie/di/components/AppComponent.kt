package br.com.luisfelipeas5.muvie.di.components

import br.com.luisfelipeas5.muvie.di.modules.HelpersModule
import br.com.madeinlabs.mvpbase.di.SchedulerModule
import dagger.Component

@Component(modules = [SchedulerModule::class, HelpersModule::class])
abstract class AppComponent: BaseComponent