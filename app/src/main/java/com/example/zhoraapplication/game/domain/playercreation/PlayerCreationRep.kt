package com.example.zhoraapplication.game.domain.playercreation

import com.example.zhoraapplication.game.data.playercreation.DefaultPlayer

interface PlayerCreationRep<T> {

    fun add(defaultPlayer: T)

    fun remove(defaultPlayer: T)

}