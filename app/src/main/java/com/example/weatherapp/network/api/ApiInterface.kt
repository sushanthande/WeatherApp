package com.example.weatherapp.network.api

import com.example.weatherapp.model.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by shande on 23-08-2021
 */
interface ApiInterface {

    @GET("weather")
    fun getWeatherData(@Query("units") units: String,
                               @Query("lat") lat: String,
                               @Query("lon") lon: String,
                               @Query("appid") apiKey: String): Call<WeatherResponse>

}