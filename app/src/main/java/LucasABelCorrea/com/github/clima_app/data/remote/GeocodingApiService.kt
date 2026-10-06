package LucasABelCorrea.com.github.clima_app.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApiService {
    @GET("v1/search")
    suspend fun searchCity(@Query("name") name: String): GeocodingResponseDto
}