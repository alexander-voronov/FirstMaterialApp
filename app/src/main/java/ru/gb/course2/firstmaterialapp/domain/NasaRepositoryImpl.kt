package ru.gb.course2.firstmaterialapp.domain

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.gb.course2.firstmaterialapp.BuildConfig
import ru.gb.course2.firstmaterialapp.api.NasaApi
import ru.gb.course2.firstmaterialapp.api.PictureOfTheDayResponse

//private const val API_KEY = "--Your API key--"

class NasaRepositoryImpl : NasaRepository {

    private val api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.nasa.gov/")
        .client(OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
            .build()
        )
        .build()
        .create(NasaApi::class.java)

    override suspend fun pictureOfTheDay(): PictureOfTheDayResponse =
        //api.pictureOfTheDay(API_KEY)
        api.pictureOfTheDay(BuildConfig.API_KEY)
}