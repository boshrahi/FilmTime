package io.boshra.filmtime.data.network

import io.boshra.filmtime.data.network.adapter.NetworkResponse
import io.boshra.filmtime.data.network.response.TmdbErrorResponse
import io.boshra.filmtime.data.network.response.TmdbShowsListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbShowsService {

  @GET("/3/trending/tv/day")
  suspend fun getTrendingShows(
    @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
  ): NetworkResponse<TmdbShowsListResponse, TmdbErrorResponse>
}
