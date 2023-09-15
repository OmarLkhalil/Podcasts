package com.mobilebreakero.search.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mobilebreakero.domain.entity.ResultsItem

internal class SearchDiffUtil : DiffUtil.ItemCallback<ResultsItem>(){
    override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean =
        oldItem == newItem
}