package com.team1.weather.models

import com.google.gson.annotations.SerializedName

data class Wind(
        @SerializedName("speed") var windSpeed: Double,
        @SerializedName("deg") var windDegree: Double
)