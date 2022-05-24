package ru.gb.course2.firstmaterialapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.gb.course2.firstmaterialapp.domain.NasaRepository
import java.io.IOException

class MainViewModel(private val repository: NasaRepository) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: Flow<Boolean> = _loading

    private val _image: MutableStateFlow<String?> = MutableStateFlow(null)
    val image: Flow<String?> = _image

    private val _error: MutableSharedFlow<String> = MutableSharedFlow()
    val error: Flow<String> = _error

    fun requestPictureOfTheDay() {

        _loading.value = true
        // запись данных во Flow

        viewModelScope.launch {

            try {
                val url = repository.pictureOfTheDay().url
                // suspend (приостановить) функция

                _image.emit(url)

            } catch (exc: IOException) {
                _error.emit("Network error")
            }

            _loading.emit(false)

        }

    }

}

class MainViewModelFactory(private val repository: NasaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(repository) as T
}