package com.example.courierapp.data.remote

import com.example.courierapp.data.remote.dto.UserInfDto
import com.example.courierapp.domain.model.LoginBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CourierApi {
    @POST("/api/v1/user/auth")
    suspend fun login(
        @Query("login") login: String,
        @Query("password") password: String
    ): UserInfDto

}