package ru.gb.course2.firstmaterialapp.api

import retrofit2.http.GET

interface NasaApi {
    @GET("planetary/apod")
    suspend fun pictureOfTheDay(): PictureOfTheDayResponse
}