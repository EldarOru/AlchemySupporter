package com.example.zhoraapplication.game.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zhoraapplication.core.presentation.BaseFragment
import com.example.zhoraapplication.databinding.MainFragmentBinding
import com.example.zhoraapplication.game.presentation.playercreation.PlayerCreationFragment

class MainFragment : BaseFragment<MainFragmentBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): MainFragmentBinding =
        MainFragmentBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startButton.setOnClickListener {
            showFragment.show(PlayerCreationFragment())
        }
    }
}