package LucasABelCorrea.com.github.clima_app.domain.model

data class WeatherForecast(
    val currentTemperature: Double,
    val weatherCode: Int,
    val dailyMaxTemperatures: List<Double>,
    val dailyMinTemperatures: List<Double>
)