package com.example.learningmultiviewrecyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learningmultiviewrecyclerviewproject.adapter.FeedAdapter
import com.example.learningmultiviewrecyclerviewproject.databinding.ActivityMainBinding
import com.example.learningmultiviewrecyclerviewproject.model.Feed

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FeedAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = FeedAdapter(mockData())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    private fun mockData(): List<Feed> = listOf(
        Feed.ImagePost(R.drawable.ic_launcher_background,"This is a first test description.","Mert"),
        Feed.ImagePost(R.drawable.ic_launcher_background,"This is a second test description.","Mert"),
        Feed.TextPost("Mert","This is a TextPost test description. I hope our code works perfectly","Feeling: Good."),
        Feed.ImagePost(R.drawable.ic_launcher_background,"This is a third test description.","Mert"),
        Feed.TextPost("Mert","This is a second TextPost test description. I hope our code works perfectly","Feeling: Perfect.")
        )
}