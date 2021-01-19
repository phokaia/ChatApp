package com.yeocak.chatapp

import com.yeocak.chatapp.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitObject {

    companion object{

        private val retrofit by lazy {

            Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build()
        }

        val api by lazy {
            retrofit.create(NotificationService::class.java)
        }

    }

}