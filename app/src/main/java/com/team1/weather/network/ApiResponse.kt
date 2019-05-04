package com.team1.weather.network

import com.team1.weather.models.CurrentWeatherResponse
import com.team1.weather.models.ForecastResponse
import com.team1.weather.utils.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiResponse{
    @GET("weather")
    fun getCityData(@Query("q") city: String): Call<CurrentWeatherResponse>

    @GET("forecast")
    fun getForecastData(@Query("q")city: String): Call<ForecastResponse>
}