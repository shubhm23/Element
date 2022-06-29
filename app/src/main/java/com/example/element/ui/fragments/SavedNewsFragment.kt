package com.example.element.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.element.R
import com.example.element.ui.NewsActivity
import com.example.element.ui.NewsViewModel

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news){
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}