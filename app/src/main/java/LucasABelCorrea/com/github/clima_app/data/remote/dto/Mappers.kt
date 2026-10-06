package LucasABelCorrea.com.github.clima_app.data.remote.dto

fun GeocodingResultDto.toDomain(): City = City(
    id = id,
    name = name,
    country = country,
    latitude = latitude,
    longitude = longitude
)

fun ForecastResponseDto.toDomain(): WeatherForecast = WeatherForecast(
    currentTemperature = current.temperature,
    weatherCode = current.weatherCode,
    dailyMaxTemperatures = daily.maxTemperatures,
    dailyMinTemperatures = daily.minTemperatures
)