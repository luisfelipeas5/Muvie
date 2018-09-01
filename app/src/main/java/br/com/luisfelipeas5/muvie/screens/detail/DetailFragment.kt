package br.com.luisfelipeas5.muvie.screens.detail

import br.com.luisfelipeas5.muvie.R
import br.com.luisfelipeas5.muvie.androidview.BaseFragment
import br.com.luisfelipeas5.muvie.di.components.BaseComponent
import br.com.luisfelipeas5.muvie.screens.detail.di.DetailModule

class DetailFragment: BaseFragment(), DetailContract.View {

    override fun onInitInject(component: BaseComponent) = component.module(DetailModule()).inject(this)

    override fun getLayoutResource(): Int = R.layout.fragment_detail

    override fun onInitView() {

    }

}