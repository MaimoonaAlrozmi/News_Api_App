package com.maimoona.newsapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maimoona.newsapi.Api.NewsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFetcher {

    private val newApi: NewsApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.191.1")
            .addConverterFactory(GsonConverterFactory.create()).build()
        newApi = retrofit.create(NewsApi::class.java)
    }

    fun fetchContents(): LiveData<List<News>> {
        val responseLiveData: MutableLiveData<List<News>> = MutableLiveData()
        val newRequest: Call<List<News>> = newApi.fetchContents()
        newRequest.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                Log.e("tag", "Failed to fetch news${t.message}")
            }

            override fun onResponse(
                call: Call<List<News>>,
                response: Response<List<News>>
            ) {
                Log.d("tag", "Response received ${response.code().toString()} ")
                val newshResponse: List<News>? = response.body()

                var newItems: List<News> = newshResponse
                    ?: mutableListOf()

                responseLiveData.value = newItems
            }
        })
        return responseLiveData
    }
}