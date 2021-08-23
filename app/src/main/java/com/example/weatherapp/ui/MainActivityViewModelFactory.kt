package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by shande on 23-08-2021
 */
class MainActivityViewModelFactory(private val cityRepository: MainActivityRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(cityRepository) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}