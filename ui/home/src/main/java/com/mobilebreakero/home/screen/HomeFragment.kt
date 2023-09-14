package com.mobilebreakero.home.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobilebreakero.common.extension.hide
import com.mobilebreakero.common.extension.show
import com.mobilebreakero.domain.util.Resource
import com.mobilebreakero.home.bestpodcastsadapter.PodcastAdapter
import com.mobilebreakero.home.curatedpodcastsadapter.CuratedPodcastsAdapter
import com.mobilebreakero.home.databinding.FragmentHomeBinding
import com.mobilebreakero.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var podcastViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        podcastViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBestPodRecyclerView()
        setupCuratedPodRecyclerView()
    }

    private fun setupBestPodRecyclerView() {
        val adapter = PodcastAdapter(requireContext())

        lifecycleScope.launch {
            podcastViewModel.getPodcasts().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        binding.progressBar.hide()
                        adapter.submitList(result.data?.podcasts)
                    }

                    is Resource.Loading -> {
                        binding.progressBar.show()

                    }

                    else -> {
                        binding.progressBar.hide()

                    }
                }
            }.launchIn(lifecycleScope)
            layoutManager(binding.podcastRecyclerView)
            binding.podcastRecyclerView.adapter = adapter
        }
    }

    private fun setupCuratedPodRecyclerView() {
        val adapter = CuratedPodcastsAdapter(requireContext())

        lifecycleScope.launch {
            podcastViewModel.getCuratedPodcasts().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        binding.progressBar.hide()
                        adapter.submitList(result.data?.curatedPodcasts)
                    }

                    is Resource.Loading -> {
                        binding.progressBar.show()

                    }

                    else -> {
                        binding.progressBar.hide()

                    }
                }
            }.launchIn(lifecycleScope)
            layoutManager(binding.curatedPodcastRecyclerView)
            binding.curatedPodcastRecyclerView.adapter = adapter
        }
    }


    private fun layoutManager(recyclerView: RecyclerView){
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
    }
}