package com.example.zhoraapplication.game.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.zhoraapplication.core.presentation.BaseFragment
import com.example.zhoraapplication.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainFragmentBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): MainFragmentBinding =
        MainFragmentBinding.inflate(inflater, container, false)

}