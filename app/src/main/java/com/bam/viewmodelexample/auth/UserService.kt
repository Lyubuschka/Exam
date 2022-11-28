package com.bam.viewmodelexample.auth

import com.bam.viewmodelexample.room.UserData
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("/users")
    fun getAll(): Call<List<UserResponse>>
}