package com.vk.tools.vktools.data.util

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.vk.tools.vktools.data.entities.Base
import com.vk.tools.vktools.data.entities.Friend

object ResponseParser {

    @Throws(JsonSyntaxException::class)
    fun parseFriends(body: String): List<Friend> {
        val response = Gson().fromJson<Base>(body)
        return response.response.items
    }
}