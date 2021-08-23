package com.example.weatherapp.model

/**
 * Created by shande on 23-08-2021
 */
sealed class Status {
    object Success : Status()
    object Error : Status()
    object Loading : Status()
}