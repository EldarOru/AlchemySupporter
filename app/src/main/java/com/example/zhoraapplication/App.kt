package com.example.zhoraapplication

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.zhoraapplication.core.presentation.Communication
import com.example.zhoraapplication.game.presentation.playercreation.PlayerCreationViewModel

class App: Application(), ProvideViewModel {

    private lateinit var viewModel: PlayerCreationViewModel

    override fun onCreate() {
        super.onCreate()

        viewModel = PlayerCreationViewModel(Communication.Base(MutableLiveData()))
    }

    override fun provide(): PlayerCreationViewModel = viewModel
}

interface ProvideViewModel {

    fun provide() : PlayerCreationViewModel
}