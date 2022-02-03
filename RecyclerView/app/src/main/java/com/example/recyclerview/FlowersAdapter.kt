package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.data.Flower
import com.example.recyclerview.databinding.ItemFlowerBinding

class FlowersAdapter(private val flowersList: List<Flower>) : RecyclerView.Adapter<ViewHolderFlower>() {

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderFlower.from(parent)

    @Override
    override fun onBindViewHolder(holder: ViewHolderFlower, position: Int) {
        holder.bind(flowersList[position])
    }

    @Override
    override fun getItemCount() = flowersList.size
}

class ViewHolderFlower(private val binding: ItemFlowerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(flower: Flower) {
        binding.flowerText.text = flower.name
        binding.flowerImage.setImageResource(flower.image ?: R.drawable.rose)
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolderFlower {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemFlowerBinding.inflate(layoutInflater, parent, false)
            return ViewHolderFlower(binding)
        }
    }
}

