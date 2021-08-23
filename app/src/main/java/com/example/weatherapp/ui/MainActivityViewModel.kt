package com.example.weatherapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.Resource
import com.example.weatherapp.model.WeatherResponse

/**
 * Created by shande on 23-08-2021
 */
class MainActivityViewModel(private val mainActivityRepository: MainActivityRepository): ViewModel() {

    val weatherLiveData: LiveData<Resource<WeatherResponse>>
        get() = weatherData

    private val weatherData = MutableLiveData<Resource<WeatherResponse>>()

    fun getWeatherData(units:String, lat:String, long:String, apiKey:String){

        mainActivityRepository.getWeatherData(units,lat,long,apiKey,
            onSuccess = {weatherResponse->

                weatherData.value = Resource.success(data = weatherResponse)

        }, onFailed = {message->

                weatherData.value = Resource.error(data = null, msg = message)

        })

    }

}