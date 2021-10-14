package br.com.cotemig.jogadoresdefutebol.services

import br.com.cotemig.jogadoresdefutebol.models.Player
import br.com.cotemig.jogadoresdefutebol.models.PlayerList
import retrofit2.Call
import retrofit2.http.GET

interface ServicePlayer {

    @GET("amigos")
    fun getPlayers(): Call<PlayerList>
}