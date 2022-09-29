package com.example.zhoraapplication.game.data.playercreation

data class DefaultPlayer(
    private val id: Int,
    private val name: String
) {

    fun sameId(defaultPlayer: DefaultPlayer) = this.id == defaultPlayer.id

    fun sameItem(defaultPlayer: DefaultPlayer) = this == defaultPlayer
}