package com.vk.tools.vktools.data.entities

import com.google.gson.annotations.SerializedName

data class Friend(
    @SerializedName("id") val id: Long,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("photo_100") val photo: String
)