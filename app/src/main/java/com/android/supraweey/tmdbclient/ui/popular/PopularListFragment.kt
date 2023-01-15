package com.android.supraweey.tmdbclient.ui.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private lateinit var linearLayoutManager: LinearLayoutManager
    private val popularAdapter: PopularAdapter by lazy {
        PopularAdapter().onClick {
            // open detail
        }
    }

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
        setUpRecyclerView()
        onObserve()
    }

    private fun setUpRecyclerView() {
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.rvPopular.apply {
            layoutManager = linearLayoutManager
        }
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