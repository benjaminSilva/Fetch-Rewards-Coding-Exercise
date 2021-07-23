package com.bsoftwares.fetchrewardscodingexercise.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bsoftwares.fetchrewardscodingexercise.R
import com.bsoftwares.fetchrewardscodingexercise.databinding.ItemLayoutBinding
import com.bsoftwares.fetchrewardscodingexercise.model.Data
import com.bsoftwares.fetchrewardscodingexercise.utils.createDifferentColorForEachListId
import com.bsoftwares.fetchrewardscodingexercise.utils.getRandomColor

class FetchAdapter : ListAdapter<Data, FetchAdapter.ViewHolder>(SearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,listOfColors)
    }

    private val listOfColors = mutableListOf<Int>()

    fun swapData(dataList : List<Data>){
        listOfColors.addAll(createDifferentColorForEachListId(dataList))
        submitList(dataList)
    }

    class ViewHolder private constructor(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Data,
            colors : List<Int>
        ) {
            binding.background.backgroundTintList = ColorStateList.valueOf(colors[item.listId-1])
            binding.id.text = item.id.toString()
            binding.listID.text = item.listId.toString()
            binding.name.text = item.name
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    class SearchDiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(
            oldItem: Data,
            newItem: Data
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Data,
            newItem: Data
        ): Boolean {
            return oldItem == newItem
        }

    }
}