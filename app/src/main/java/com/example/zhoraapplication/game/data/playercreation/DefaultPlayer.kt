package com.example.zhoraapplication.game.data.playercreation

import android.os.Parcelable
import android.widget.TextView
import kotlinx.parcelize.Parcelize


@Parcelize
data class DefaultPlayer(
    private val id: Int,
    private val name: String
): Parcelable {

    fun sameId(defaultPlayer: DefaultPlayer) = this.id == defaultPlayer.id

    fun sameItem(defaultPlayer: DefaultPlayer) = this == defaultPlayer

    fun setText(view: TextView) {
        view.text = name
    }
}