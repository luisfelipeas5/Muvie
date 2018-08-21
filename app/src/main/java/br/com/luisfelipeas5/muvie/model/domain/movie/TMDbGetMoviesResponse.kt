package br.com.luisfelipeas5.muvie.model.domain.movie

import com.google.gson.annotations.SerializedName

class TMDbGetMoviesResponse {
    @SerializedName("results")
    var movies: List<TMDbMovie>? = null
}
