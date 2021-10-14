package br.com.cotemig.jogadoresdefutebol.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val urlBase = "https://mockup.fluo.app/v1/";

    private val retrofitMockup = Retrofit.Builder()
        .baseUrl(urlBase)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun servicePlayer(): ServicePlayer {
        return retrofitMockup.create(ServicePlayer::class.java)
    }
}