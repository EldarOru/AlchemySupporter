package com.example.zhoraapplication.game.presentation.playercreation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.zhoraapplication.core.presentation.BaseFragment
import com.example.zhoraapplication.databinding.FragmentAddPlayerBinding

class PlayerCreationFragment : BaseFragment<FragmentAddPlayerBinding>() {

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddPlayerBinding = FragmentAddPlayerBinding.inflate(inflater, container, false)

}