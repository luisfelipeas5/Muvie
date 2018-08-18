package br.com.madeinlabs.mvpbase.di

import br.com.madeinlabs.mvpbase.schedulerprovider.AppSchedulerProvider
import br.com.madeinlabs.mvpbase.schedulerprovider.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class SchedulerModule {

    @Provides
    fun provideAppSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}