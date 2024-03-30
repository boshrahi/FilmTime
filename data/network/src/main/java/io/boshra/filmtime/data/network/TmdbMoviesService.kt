package io.boshra.filmtime.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbMoviesService {

  @GET("/3/movie/{movie_id}")
  suspend fun getMovieDetails(
    @Path("movie_id") movieId: Int,
    @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
  ): TmdbMovieDetailsResponse
}
