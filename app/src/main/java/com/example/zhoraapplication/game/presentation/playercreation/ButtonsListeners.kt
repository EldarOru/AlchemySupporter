package com.example.zhoraapplication.game.presentation.playercreation

import com.example.zhoraapplication.game.data.playercreation.DefaultPlayer

interface ButtonsListeners {

    fun addPlayer(defaultPlayer: DefaultPlayer)

    fun removePlayer(defaultPlayer: DefaultPlayer)
}