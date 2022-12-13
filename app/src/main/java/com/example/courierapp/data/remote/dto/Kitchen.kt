package com.example.courierapp.data.remote.dto

data class Kitchen(
    val coords: String,
    val created_at: String,
    val description: String,
    val has_delivery: Boolean,
    val has_monitor: Boolean,
    val id: Int,
    val metro: String,
    val phone: String,
    val store_code: String,
    val updated_at: String
)