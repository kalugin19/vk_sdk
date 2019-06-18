package com.vk.tools.vktools.data.entities

import com.google.gson.annotations.SerializedName

data class Friend(
    @SerializedName("id") val id: Long,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("photo_100") val photo: String,
    @SerializedName("deactivated") val deactivated: String,
    @SerializedName("can_access_closed") val can_access_closed: String
)