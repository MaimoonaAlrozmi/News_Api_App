package com.maimoona.newsapi

import com.google.gson.annotations.SerializedName
import java.util.*

data class News(
    var id: Int,
    @SerializedName("news_title")
    var title: String,
    @SerializedName("news_details")
    var details: String,
    @SerializedName("news_date")
    var date: Date,
    @SerializedName("news_image")
    var image: String,
    @SerializedName("id_category")
    var id_category: Int
) {}
