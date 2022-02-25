package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = ItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            viewModelStore,
            defaultViewModelProviderFactory
        ).get(MainViewModel::class.java)

        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        viewModel.items.observe(this) { items ->
            adapter.setItems(items)
        }

        binding.button.setOnClickListener {
            val value = binding.text.text.toString()
            if (value.isEmpty()) {
                return@setOnClickListener
            }
            val item = viewModel.createItem(value)
            viewModel.addItem(item)
        }


    }
}