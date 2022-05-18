package ru.gb.course2.firstmaterialapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.gb.course2.firstmaterialapp.domain.NasaRepository
import java.io.IOException

class MainViewModel(private val repository: NasaRepository) : ViewModel() {

    fun requestPictureOfTheDay() {

        viewModelScope.launch {

            try {
                val url = repository.pictureOfTheDay().url
                // suspend (приостановить) функция
            } catch (exc: IOException ) {

            }

        }

    }

}

class MainViewModelFactory(val repository: NasaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(repository) as T
}