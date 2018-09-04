package br.com.luisfelipeas5.muvie.model.domain.movie

import com.google.gson.annotations.SerializedName

class TMDbMovie: Movie {

    companion object {
        private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
        const val SMALL_IMAGE_BASE_URL = "${IMAGE_BASE_URL}w500"
        const val ORIGINAL_IMAGE_BASE_URL = "${IMAGE_BASE_URL}original"
    }

    private var title: String? = null
    private var id: String? = null
    @SerializedName("backdrop_path")
    private val backdrop: String? = null
    @SerializedName("poster_path")
    private val poster: String? = null
    private val overview: String? = null

    override fun getName(): String? = title

    override fun getId(): String? = id

    override fun getOverview(): String? = overview

    override fun getSmallCover(): String? = "$SMALL_IMAGE_BASE_URL$backdrop"

    override fun getCover(): String? = "$ORIGINAL_IMAGE_BASE_URL$poster"

}
