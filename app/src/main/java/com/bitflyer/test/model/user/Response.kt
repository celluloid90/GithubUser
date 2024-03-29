package com.bitflyer.test.model.user

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("total_count")
    val totalCount: Int?,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean?,
    val items: List<User>
)
