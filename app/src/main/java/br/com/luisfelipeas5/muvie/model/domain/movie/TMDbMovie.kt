package br.com.luisfelipeas5.muvie.model.domain.movie

class TMDbMovie: Movie {
    private var title: String? = null
    private var id: String? = null

    override fun getName(): String? = title

    override fun getId(): String? = id

}
