package com.example.element.repository

import com.example.element.api.RetrofitInstance
import com.example.element.db.ArticleDatabase
import retrofit2.Retrofit

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}