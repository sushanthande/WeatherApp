package com.example.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.API_KEY
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.Status

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, MainActivityViewModelFactory(MainActivityRepository()))
            .get(MainActivityViewModel::class.java)
        observeViewModel()

        viewModel.getWeatherData(units = "metric",lat = "18.52", long = "73.85", API_KEY)
    }

    private fun observeViewModel(){

        viewModel.weatherLiveData.observe(this){resource->

            when (resource.status) {

                Status.Loading -> {
                    binding.progressHorizontal.isVisible = true
                    binding.progressHorizontal.animate()
                }

                Status.Success -> {
                    resource.data?.let { weather ->

                            binding.progressHorizontal.isVisible = false

                            binding.weatherCard.isVisible = true

                            weather.let { weatherResponse ->

                                with(binding) {

                                    tvMinTemp.text =
                                        weatherResponse.main.temp_min.toString()

                                    tvMaxTemp.text =
                                        weatherResponse.main.temp_max.toString()

                                }

                        }

                    }
                }

                Status.Error -> {
                    Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show()
                }

            }


        }

    }

}