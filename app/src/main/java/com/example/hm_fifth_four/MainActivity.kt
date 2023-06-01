package com.example.hm_fifth_four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.CounterViewModel
import com.example.hm_fifth_four.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        binding.btnPlus.setOnClickListener {
            counterViewModel.increment()
        }
        binding.btnMinus.setOnClickListener {
            counterViewModel.decrement()
        }
        counterViewModel.state.observe(this, Observer {
            binding.textView.text = it.toString()
        })
    }
}