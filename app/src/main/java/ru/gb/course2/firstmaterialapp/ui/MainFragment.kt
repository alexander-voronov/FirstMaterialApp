package ru.gb.course2.firstmaterialapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.gb.course2.firstmaterialapp.R
import ru.gb.course2.firstmaterialapp.databinding.FragmentMainBinding

class MainFragment : Fragment (R.layout.fragment_main){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)
    }
}