package com.example.podcast

import android.os.Bundle
import android.util.Log


import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.viewmodel.GenresViewModel
import com.google.android.material.tabs.TabLayout
import com.mobilebreakero.data.remote.PodcastApi
import com.mobilebreakero.domain.entity.Genres
import com.mobilebreakero.domain.entity.GenresItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PodcastFragment : Fragment() {
    lateinit var tabLayout: TabLayout
    var genresList: List<GenresItem?>? = null
    lateinit var progressBar: ProgressBar
    lateinit var viewModel: GenresViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[GenresViewModel::class.java]

        return inflater.inflate(R.layout.fragment_podcast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tab_layout)
        progressBar = view.findViewById(R.id.progress_bar)
        lifecycleScope.launch { genresList = viewModel.getGenresList() }
        Log.e("List", genresList?.size.toString());
        showTabs()
    }

    private fun showTabs(){
        genresList!!.forEach {item ->
            val tab = tabLayout.newTab()
            tab.text = item!!.name
            tabLayout.addTab(tab)
        }
    }

}