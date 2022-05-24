package ru.gb.course2.firstmaterialapp.domain

import ru.gb.course2.firstmaterialapp.api.PictureOfTheDayResponse

interface NasaRepository {

    suspend fun pictureOfTheDay(): PictureOfTheDayResponse
}