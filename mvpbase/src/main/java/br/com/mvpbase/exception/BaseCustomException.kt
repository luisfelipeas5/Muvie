package br.com.madeinlabs.mvpbase.exception

abstract class BaseCustomException: Throwable() {
    abstract fun getMessageResourceId(): Int
}