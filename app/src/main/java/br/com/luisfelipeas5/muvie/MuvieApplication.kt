package br.com.luisfelipeas5.muvie

import android.app.Application
import br.com.luisfelipeas5.muvie.di.components.BaseComponent
import br.com.luisfelipeas5.muvie.di.components.DaggerAppComponent
import br.com.luisfelipeas5.muvie.di.modules.HelpersModule

class MuvieApplication: Application() {

    lateinit var component: BaseComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .helpersModule(HelpersModule(this))
                .build()
    }
}