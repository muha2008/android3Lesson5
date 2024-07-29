package com.example.android3lesson5.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.android3lesson5.data.remote.models.ResultsItem
import com.example.android3lesson5.databinding.ItemTitansBinding

class TitanAdapter : ListAdapter<ResultsItem, TitanAdapter.TitanViewHolder>(DiffUtilCallback()) {

    inner class TitanViewHolder(private val binding: ItemTitansBinding) : ViewHolder(binding.root) {

        fun bind(item: ResultsItem) {
            Glide.with(binding.ivCover.context).load(item.img)
                .into(binding.ivCover)
            binding.tvName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitanViewHolder {
        return TitanViewHolder(
            ItemTitansBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TitanViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        class DiffUtilCallback : DiffUtil.ItemCallback<ResultsItem>() {
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}