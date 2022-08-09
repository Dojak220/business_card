package me.dio.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.dio.businesscard.R
import me.dio.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}