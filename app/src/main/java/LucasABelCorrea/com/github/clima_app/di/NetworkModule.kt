package LucasABelCorrea.com.github.clima_app.di

import LucasABelCorrea.com.github.clima_app.data.remote.ForecastApiService
import LucasABelCorrea.com.github.clima_app.data.remote.GeocodingApiService
import com.google.gson.Gson
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GeocodingRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ForecastRetrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    @GeocodingRetrofit
    fun provideGeocodingRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://geocoding-api.open-meteo.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    @ForecastRetrofit
    fun provideForecastRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    fun provideGeocodingApiService(@GeocodingRetrofit retrofit: Retrofit): GeocodingApiService =
        retrofit.create(GeocodingApiService::class.java)

    @Provides
    @Singleton
    fun provideForecastApiService(@ForecastRetrofit retrofit: Retrofit): ForecastApiService =
        retrofit.create(ForecastApiService::class.java)
}