package io.boshra.filmtime.data.network

import io.boshra.filmtime.data.network.adapter.NetworkResponse
import io.boshra.filmtime.data.network.response.TmdbErrorResponse
import io.boshra.filmtime.data.network.response.TmdbMovieDetailsResponse
import io.boshra.filmtime.data.network.response.TmdbVideoListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbMoviesService {

  @GET("/3/movie/{movie_id}")
  suspend fun getMovieDetails(
    @Path("movie_id") movieId: Int,
    @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
  ): NetworkResponse<TmdbMovieDetailsResponse, TmdbErrorResponse>

  @GET("/3/trending/movie/day")
  suspend fun getTrendingMovies(
    @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
  ): NetworkResponse<TmdbVideoListResponse, TmdbErrorResponse>

  @GET("/3/trending/tv/day")
  suspend fun getTrendingShows(
    @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
  ): NetworkResponse<TmdbVideoListResponse, TmdbErrorResponse>
}
