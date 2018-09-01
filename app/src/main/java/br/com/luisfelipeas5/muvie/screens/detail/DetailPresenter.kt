package br.com.luisfelipeas5.muvie.screens.detail

import br.com.madeinlabs.mvpbase.schedulerprovider.SchedulerProvider
import br.com.mvpbase.contract.BasePresenter

class DetailPresenter(schedulerProvider: SchedulerProvider, interactor: DetailInteractor) : BasePresenter<DetailContract.View>(), DetailContract.Presenter {
}