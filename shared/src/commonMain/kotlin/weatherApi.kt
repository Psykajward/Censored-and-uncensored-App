import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class WeatherResponse(val temp: Double, val humidity: Int)

object WeatherApi {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5"

    suspend fun getWeather(city: String, apiKey: String): WeatherResponse {
        val response: String = NetworkClient.get("$BASE_URL/weather?q=$city&appid=$apiKey")
        return Json.decodeFromString(response)
    }
}
