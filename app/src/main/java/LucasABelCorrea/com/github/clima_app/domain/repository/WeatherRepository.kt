package LucasABelCorrea.com.github.clima_app.domain.repository

import LucasABelCorrea.com.github.clima_app.domain.model.City
import LucasABelCorrea.com.github.clima_app.domain.model.WeatherForecast
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun searchCity(query: String): Flow<Result<List<City>>>
    fun getForecast(city: City): Flow<Result<WeatherForecast>>
}