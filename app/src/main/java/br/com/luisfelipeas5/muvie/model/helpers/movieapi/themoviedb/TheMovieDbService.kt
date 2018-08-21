package br.com.luisfelipeas5.muvie.model.helpers.movieapi.themoviedb

import android.content.Context
import br.com.luisfelipeas5.muvie.R
import br.com.luisfelipeas5.muvie.model.domain.movie.TMDbGetMoviesResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface TheMovieDbService {

    object Factory {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun build(context: Context): TheMovieDbService {
            val theMovieDbKey = context.getString(R.string.tmdb_api_key)
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        var request = chain.request()

                        val url = request.url()
                                .newBuilder()
                                .addQueryParameter(TheMovieDbKeys.API_KEY, theMovieDbKey)
                                .build()

                        request = request.newBuilder().url(url).build()
                        chain.proceed(request)
                    }
                    .build()

            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(TheMovieDbService::class.java)
        }
    }

    @GET(TheMovieDbMethods.DISCOVER_MOVIE)
    fun getMovies(@Query(TheMovieDbKeys.PAGE) page: Int): Single<TMDbGetMoviesResponse>

}
