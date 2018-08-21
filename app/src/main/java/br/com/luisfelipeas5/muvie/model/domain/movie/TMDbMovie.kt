package br.com.luisfelipeas5.muvie.model.domain.movie

import com.google.gson.annotations.SerializedName

class TMDbMovie: Movie {

    companion object {
        private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
        const val SMALL_IMAGE_BASE_URL = "${IMAGE_BASE_URL}w500"
    }

    private var title: String? = null
    private var id: String? = null
    @SerializedName("backdrop_path")
    private val backdrop: String? = null

    override fun getName(): String? = title

    override fun getId(): String? = id

    override fun getSmallCover(): String? = "$SMALL_IMAGE_BASE_URL$backdrop"

}
