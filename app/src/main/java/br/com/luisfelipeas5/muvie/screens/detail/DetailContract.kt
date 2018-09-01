package br.com.luisfelipeas5.muvie.screens.detail

import br.com.mvpbase.contract.Contract

interface DetailContract: Contract {

    interface View: Contract.View
    interface Presenter: Contract.Presenter<View>
    interface Interactor: Contract.Interactor

}