package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.data.Flower
import com.example.recyclerview.databinding.ItemFlowerBinding

class FlowersAdapter(private val flowersList: List<Flower>, private val itemClicked: FlowerClicked) :
    RecyclerView.Adapter<ViewHolderFlower>() {

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderFlower(ItemFlowerBinding.inflate(LayoutInflater.from(parent.context), parent, false), itemClicked)

    @Override
    override fun onBindViewHolder(holder: ViewHolderFlower, position: Int) {
        holder.bind(flowersList[position])
    }

    @Override
    override fun getItemCount() = flowersList.size
}

class ViewHolderFlower(private val binding: ItemFlowerBinding, private val itemClicked: FlowerClicked) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(flower: Flower) {
        binding.flowerText.text = flower.name
        binding.flowerImage.setImageResource(flower.image ?: R.drawable.rose)
        binding.apply {
            this.root.setOnClickListener { itemClicked.onFlowerClicked(flower.name, flower.unicode) }
        }
    }
}

