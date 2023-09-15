package com.mobilebreakero.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.mobilebreakero.domain.entity.ResultsItem
import com.mobilebreakero.search.databinding.SearchedItemBinding

class SearchAdapter(
    private val context: Context
) : ListAdapter<ResultsItem, SearchViewHolder>(SearchDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = SearchedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = getItem(position)
        Glide.with(context).load(item.thumbnail).into(holder.binding.searchItemImage)
        holder.binding.searchItemText.text = item.titleOriginal
    }

}