package com.team1.weather.models

import com.google.gson.annotations.SerializedName
import com.team1.weather.models.ForecastDetail

data class ForecastResponse(
        @SerializedName("list") var forecast: List<ForecastDetail>
)