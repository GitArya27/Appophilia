package com.example.myapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameService {
    @GET("game")
    suspend fun getGameByID(
        @Query("id") GameID: Int
    ): Response<GetGameByIDResponse>
}