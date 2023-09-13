package com.mobilebreakero.home.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mobilebreakero.home.adapter.PodcastAdapter
import com.mobilebreakero.home.databinding.FragmentHomeBinding
import com.mobilebreakero.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.internal.Contexts.getApplication
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var podcastViewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        podcastViewModel = ViewModelProvider(
            this
        )[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        val adapter = PodcastAdapter(requireContext())
        podcastViewModel.fetchPodcasts()
        lifecycleScope.launch {
            podcastViewModel._podcasts.collect {
                adapter.submitList(it?.podcasts)
                binding.podcastRecyclerView.adapter = adapter
            }
        }
    }
}