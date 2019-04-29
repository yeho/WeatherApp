package com.team1.weather

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.team1.weather.models.CurrentWeatherResponse
import com.team1.weather.network.ApiClient
import com.team1.weather.network.ApiResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText.setOnEditorActionListener(TextView.OnEditorActionListener { text, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                loadWeatherTodayByCity(text.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun loadWeatherTodayByCity(city: String) {
        val apiService = ApiClient().getClient().create(ApiResponse::class.java)

        val call = apiService.getCityData(city)
        call.enqueue(object : Callback<CurrentWeatherResponse> {
            override fun onResponse(call: Call<CurrentWeatherResponse>, response: Response<CurrentWeatherResponse>) {
                Log.d("CurrentDayForecast", "RESPONSE: ${response.body()}")
                Log.d(
                    "CurrentDayForecast",
                    "CELSIUS DEGREE: ${getCelsius(response.body()?.mainDetails?.currentTemperature?.toDouble())}"
                )

                tvCelsiusDegree.text =
                    getCelsius(response.body()?.mainDetails?.currentTemperature?.toDouble()).toString()
                tvCityName.text = response.body()?.cityName ?: "Unknown"
            }

            override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                Log.d("CurrentDayForecast", t.message)
            }
        })
    }

    fun getCelsius(degreesKelvin: Double?): Int {
        return degreesKelvin?.minus(273.16)!!.roundToInt()
    }
}
