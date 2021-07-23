package com.bsoftwares.fetchrewardscodingexercise

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bsoftwares.fetchrewardscodingexercise.adapter.FetchAdapter
import com.bsoftwares.fetchrewardscodingexercise.databinding.ActivityMainBinding
import com.bsoftwares.fetchrewardscodingexercise.viewModel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : AppViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getData()

        val adapter = FetchAdapter()

        binding.rv.adapter = adapter

        viewModel.data.observe(this,{
            adapter.swapData(it)
        })

    }
}