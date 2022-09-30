package com.example.zhoraapplication.game.presentation.rounds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.zhoraapplication.core.presentation.BaseFragment
import com.example.zhoraapplication.databinding.FragmentRoundBinding
import com.example.zhoraapplication.game.data.playercreation.DefaultPlayer

class GameFragment: BaseFragment<FragmentRoundBinding>() {

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRoundBinding = FragmentRoundBinding.inflate(inflater, container, false)


    companion object {

        private const val PLAYERS = "players"

        fun createInstance(list: MutableList<DefaultPlayer>) = GameFragment().apply {
            arguments = Bundle().apply {
                putParcelableArray(PLAYERS, list.toTypedArray())
            }
        }
    }
}