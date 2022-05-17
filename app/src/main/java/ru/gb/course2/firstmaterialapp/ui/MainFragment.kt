package ru.gb.course2.firstmaterialapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.gb.course2.firstmaterialapp.R
import ru.gb.course2.firstmaterialapp.databinding.FragmentMainBinding
import ru.gb.course2.firstmaterialapp.domain.NasaRepositoryImpl

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewMode: MainViewModel by viewModels { MainViewModelFactory(NasaRepositoryImpl()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)
    }
}