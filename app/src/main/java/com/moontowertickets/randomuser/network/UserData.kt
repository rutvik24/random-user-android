package com.moontowertickets.randomuser.network

import retrofit2.http.GET
import retrofit2.http.Query

interface UserData {

    @GET("/api")
    suspend fun getRandomUser(
        @Query("results") results: Int? = 5,
        @Query("page") page: Int? = 1,
    ): UserDto
}