package com.example.courierapp.data.remote.dto

data class Data(
    val id: Int,
    val kitchen: List<Kitchen>,
    val login: String,
    val name: String,
    val slug: String,
    val work_name: String
)