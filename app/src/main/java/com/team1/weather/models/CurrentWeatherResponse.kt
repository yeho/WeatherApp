package com.team1.weather.models

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("id") var id: String,
    @SerializedName("name") var cityName: String,
    @SerializedName("main") var mainDetails: Main,
    @SerializedName("wind") var windDetails: Wind,
    @SerializedName("sys") var sunInfo: Sys
)