package com.example.weatherapp.ui

import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by shande on 23-08-2021
 */
class MainActivityRepository {

    fun getWeatherData(units :String, lat:String, lon :String, apiKey:String, onSuccess: (WeatherResponse) -> Unit, onFailed: (String) -> Unit) {

        val call: Call<WeatherResponse> = ApiClient.getClient.getWeatherData(units, lat, lon,apiKey)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>) {

                response.body()?.let {weatherResponse->
                    onSuccess(weatherResponse)
                }

            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

                t.message?.let {
                    onFailed(it)
                }

            }

        })

    }

}