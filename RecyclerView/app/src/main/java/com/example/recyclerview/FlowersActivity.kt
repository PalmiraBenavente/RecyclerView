package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.data.flowerList
import com.example.recyclerview.databinding.FlowersMainBinding

class FlowersActivity : AppCompatActivity(), FlowerClicked {
    private lateinit var binding: FlowersMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FlowersMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = FlowersAdapter(flowerList(), this)
    }

    override fun onFlowerClicked(flower: String, emoji: Int) {
        val emojiText = String(Character.toChars(emoji))
        Toast.makeText(applicationContext, flower + emojiText, Toast.LENGTH_LONG).show()
    }
}
