package com.example.element.util

import android.app.DownloadManager
import com.example.element.BuildConfig.YOUR_NEWSAPI_KEY

class Constants {
    companion object{
        const val API_KEY = YOUR_NEWSAPI_KEY
        const val  BASE_URL = "https://newsapi.org"
        const val SEARCH_NEWS_TIME_DELAY = 500L
        const val QUERY_PAGE_SIZE = 20
    }

}