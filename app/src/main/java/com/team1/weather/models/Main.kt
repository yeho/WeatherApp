package com.team1.weather.models

import com.google.gson.annotations.SerializedName

data class Main(@SerializedName("temp") var currentTemperature: String,
                @SerializedName("temp_min") var minTemp: Double,
                @SerializedName("temp_max") var maxTemp: Double
)