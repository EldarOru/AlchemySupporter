package com.example.zhoraapplication.game.presentation.playercreation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.zhoraapplication.core.presentation.Communication
import com.example.zhoraapplication.core.presentation.ObserveData
import com.example.zhoraapplication.game.data.playercreation.DefaultPlayer
import com.example.zhoraapplication.game.data.playercreation.PlayerCreationRepImpl
import com.example.zhoraapplication.game.domain.playercreation.PlayerCreationRep

class PlayerCreationViewModel(
    private val communication: Communication.Mutable<List<DefaultPlayer>>,
    private val playerCreationRep: PlayerCreationRep<DefaultPlayer> = PlayerCreationRepImpl(communication)
): ViewModel(), ButtonsListeners, ObserveData<List<DefaultPlayer>> {

    override fun observe(owner: LifecycleOwner, observer: Observer<List<DefaultPlayer>>) {
        communication.observe(owner, observer)
    }

    override fun addPlayer(defaultPlayer: DefaultPlayer) {
        playerCreationRep.add(defaultPlayer)
    }

    override fun removePlayer(defaultPlayer: DefaultPlayer) {
        playerCreationRep.remove(defaultPlayer)
    }
}