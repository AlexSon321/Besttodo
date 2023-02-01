package com.example.besttodo.homeweather.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("current") val current: Current,
    @SerializedName("location") val location: Location
)