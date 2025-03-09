import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = WeatherApi.getWeather("London", "your_api_key")
                Log.d("Weather", response.toString())
            } catch (e: Exception) {
                Log.e("Error", e.message ?: "Unknown error")
            }
        }
    }
}
