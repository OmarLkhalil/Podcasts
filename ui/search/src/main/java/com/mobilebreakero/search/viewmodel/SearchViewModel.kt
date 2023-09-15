package com.mobilebreakero.search.viewmodel

import androidx.lifecycle.ViewModel
import com.mobilebreakero.domain.repo.SearchResultRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchResultRepo: SearchResultRepo
) : ViewModel(){
    fun getSearchedResult(searchedText:String) = searchResultRepo.getResult(searchedText)
}