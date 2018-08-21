package br.com.luisfelipeas5.muvie.androidview

import android.content.Context
import br.com.luisfelipeas5.muvie.MuvieApplication
import br.com.luisfelipeas5.muvie.di.components.BaseComponent
import br.com.mvpbase.androidview.BaseFragment

abstract class BaseFragment: BaseFragment() {

    override fun onInitInject(applicationContext: Context?) {
        val muvieApplication = applicationContext as MuvieApplication
        onInitInject(muvieApplication.component)
    }

    abstract fun onInitInject(component: BaseComponent)

}
