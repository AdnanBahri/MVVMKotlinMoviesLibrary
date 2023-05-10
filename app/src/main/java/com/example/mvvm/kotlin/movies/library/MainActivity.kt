package com.example.mvvm.kotlin.movies.library

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MoviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MoviesAdapter()
        val re: RecyclerView = findViewById(R.id.recycler)
        re.layoutManager = GridLayoutManager(this, 2)
        re.addItemDecoration(ItemDecorator(2, 20, false))

        viewModel.getMovies()

        lifecycleScope.launch {
            viewModel.movies.collect {
                adapter.submitList(it?.results)
                Log.d("Main Activity", "Page: " + it?.page)
                Log.d("Main Activity", "Results Size : " + it?.results?.size)
                re.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }
}