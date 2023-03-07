package com.example.myapp

class SharedRepository {
    suspend fun getGameById(GameId : Int): GetGameByIDResponse?{
        val request = NetworkLayer.apiClint.getGamebyID(GameId)
        if(request.failed){
            return null
        }
        if(!request.isSuccessful){
            return null
        }
        return request.body
    }
}