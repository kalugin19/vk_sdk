package com.vk.tools.vktools.data.base

class BaseResponse<T, E : Exception>(val data: T, exception: E)