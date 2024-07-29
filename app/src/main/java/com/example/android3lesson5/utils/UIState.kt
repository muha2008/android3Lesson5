package com.example.android3lesson5.utils

 data class UIState<T>(

    val isLoading: Boolean = true,
    val error: String? = null,
    val success: T? = null
 )