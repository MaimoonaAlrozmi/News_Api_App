package com.maimoona.newsapi.Api

import com.maimoona.newsapi.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {

    @GET("/news_api/api/api_news.php")
    fun fetchContents(): Call<List<News>>
}