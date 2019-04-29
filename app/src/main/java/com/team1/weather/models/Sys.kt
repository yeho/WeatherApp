package com.team1.weather.models

import com.google.gson.annotations.SerializedName

data class Sys(@SerializedName("sunrise") var sunriseTime: Long,
               @SerializedName("sunset") var SunsetTime: Long,
               @SerializedName("message") var dateText: String
)