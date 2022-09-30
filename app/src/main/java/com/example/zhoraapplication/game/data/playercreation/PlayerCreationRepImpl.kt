package com.example.zhoraapplication.game.data.playercreation

import com.example.zhoraapplication.core.presentation.Communication
import com.example.zhoraapplication.game.domain.playercreation.PlayerCreationRep

class PlayerCreationRepImpl(
    private val communication: Communication.Mutable<List<DefaultPlayer>>
): PlayerCreationRep<DefaultPlayer> {

    private val playerList = mutableListOf<DefaultPlayer>()

    override fun add(defaultPlayer: DefaultPlayer) {
        playerList.add(defaultPlayer)
        communication.map(playerList)
    }

    override fun remove(defaultPlayer: DefaultPlayer) {
        playerList.remove(defaultPlayer)
        communication.map(playerList)
    }
}