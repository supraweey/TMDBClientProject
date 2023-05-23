package com.android.supraweey.tmdbclient.ui.popular

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.supraweey.tmdbclient.R
import com.android.supraweey.tmdbclient.databinding.FragmentPopularListBinding
import com.android.supraweey.tmdbclient.domain.MovieBody
import com.android.supraweey.tmdbclient.ui.popular.adapter.PopularAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularListFragment : Fragment() {

    private val viewModel by viewModel<PopularViewModel>()
    lateinit var binding: FragmentPopularListBinding

    private val popularAdapter: PopularAdapter by lazy {
        PopularAdapter().onClick {
            // open detail
        }
    }
//    private val searchTextWatcher = object : SearchView.OnQueryTextListener {
//        override fun onQueryTextSubmit(query: String?): Boolean {
//
//        }
//
//        override fun onQueryTextChange(newText: String?): Boolean {
//
//        }
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.executePopular(MovieBody(getString(R.string.api_key), 1))
        binding.loading.visibility = View.VISIBLE
        onObserve()
    }

    private fun initAdapter() {
        binding.rvPopular.adapter = popularAdapter
    }

    private fun onObserve() {
        viewModel.popularMovieList.observe(requireActivity()) {
            binding.loading.visibility = View.GONE
            initAdapter()
            popularAdapter.updateItem(it)
        }
    }
}