package com.example.myapp

import retrofit2.Response
import java.lang.Exception

class ApiClient(
    private val gameService: GameService
) {
    suspend fun getGamebyID(gameId: Int ): SimpleResponse<GetGameByIDResponse>{
        return safeApiCall{ gameService.getGameByID(gameId) }
    }
    private inline fun <T> safeApiCall(apiCall: ()->Response<T>) : SimpleResponse<T>{
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e : Exception) {
            SimpleResponse.failure(e)
        }
    }
}