package com.example.element.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.element.R
import com.example.element.adapters.NewsAdapter
import com.example.element.ui.NewsActivity
import com.example.element.ui.NewsViewModel
import com.example.element.util.Resources
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "BreakingNewsFragment"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resources.Success -> {
                    hideProgressBaar()
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles)
                    }
                }

                is Resources.Error -> {
                    hideProgressBaar()
                    response.message?.let {
                        Log.e(TAG, "An error occured: $it")
                    }
                }

                is Resources.Loading -> {
                    showProgressBaar()
                }

            }

        })
    }

    private fun hideProgressBaar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBaar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}