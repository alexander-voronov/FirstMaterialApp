package ru.gb.course2.firstmaterialapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.gb.course2.firstmaterialapp.domain.NasaRepository

class MainViewModel(val repository: NasaRepository) : ViewModel() {
}

class MainViewModelFactory(val repository: NasaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(repository) as T
}