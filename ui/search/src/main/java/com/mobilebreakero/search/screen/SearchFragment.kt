package com.mobilebreakero.search.screen

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.mobilebreakero.common.extension.hide
import com.mobilebreakero.common.extension.show
import com.mobilebreakero.common.extension.showIf
import com.mobilebreakero.domain.util.Status
import com.mobilebreakero.search.adapter.SearchAdapter
import com.mobilebreakero.search.databinding.FragmentSearhBinding
import com.mobilebreakero.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearhBinding
    private lateinit var searchedAdapter: SearchAdapter
    private val searchViewModel by activityViewModels<SearchViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearhBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initRecyclerView()
        searchAction()
    }

    private fun init() {
        showKeyboard(requireContext(), binding.editText)
        searchedAdapter = SearchAdapter(requireContext())
    }

    private fun searchAction() {
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lifecycleScope.launch {
                    searchViewModel.getSearchedResult(p0.toString())
                        .onEach { resource ->
                            when (resource.status) {
                                Status.LOADING -> {
                                    binding.searchProgressBar.show()
                                }
                                Status.SUCCESS -> {
                                    val list = resource.data
                                    binding.notFound.showIf {
                                        list == null
                                    }
                                    searchedAdapter.submitList(list)
                                    binding.searchProgressBar.hide()
                                }
                                Status.FAIL -> { /* do nothing */ }
                            }
                        }
                        .launchIn(lifecycleScope)
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun initRecyclerView() {
        binding.searchRecycler.apply {
            setHasFixedSize(true)
            adapter = searchedAdapter
        }
    }

    private fun showKeyboard(context: Context, editText: EditText){
        if (editText.requestFocus()){
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED)
        }
    }
}