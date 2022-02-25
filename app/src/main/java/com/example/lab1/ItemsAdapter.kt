package com.example.lab1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.databinding.RecyclerviewItemBinding

class ItemsAdapter : RecyclerView.Adapter<ItemsViewHolder>() {
    private val items = mutableListOf<MainViewModel.Item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemsViewHolder(
            binding = RecyclerviewItemBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<MainViewModel.Item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}

class ItemsViewHolder(
    private val binding: RecyclerviewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MainViewModel.Item) {
        binding.root.text = item.value
    }
}