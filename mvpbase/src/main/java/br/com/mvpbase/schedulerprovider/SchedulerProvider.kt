package br.com.madeinlabs.mvpbase.schedulerprovider

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}