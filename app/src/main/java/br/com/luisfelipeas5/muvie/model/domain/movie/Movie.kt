package br.com.luisfelipeas5.muvie.model.domain.movie

interface Movie {
    fun getName(): String?
    fun getId(): String?
    fun getSmallCover(): String?
    fun getOverview(): String?
    fun getCover(): String?
}
