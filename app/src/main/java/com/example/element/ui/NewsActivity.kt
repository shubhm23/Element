package com.example.element.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.element.R
import androidx.navigation.ui.setupWithNavController
import com.example.element.db.ArticleDatabase
import com.example.element.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}