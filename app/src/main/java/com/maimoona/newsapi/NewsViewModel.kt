package com.maimoona.newsapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {
    val newsLiveData : LiveData<List<News>>
    init {
        newsLiveData = NewsFetcher().fetchContents();
    }
}