package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/**
 * Created by shande on 23-08-2021
 */
data class Rain(@SerializedName(  "3h") val threeHourlyVolume: Double)