package com.example.zhoraapplication.game.presentation.playercreation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zhoraapplication.databinding.DefaultPlayerItemBinding
import com.example.zhoraapplication.game.data.playercreation.DefaultPlayer

class PlayerCreationAdapter : ListAdapter<DefaultPlayer, PlayerCreationAdapter.DefaultPlayerVH >(
    AsyncDifferConfig.Builder(DiffCallback()).build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultPlayerVH {
        return DefaultPlayerVH(DefaultPlayerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DefaultPlayerVH, position: Int) {
        holder.bind(currentList[position])
    }

    class DefaultPlayerVH(
        private val defaultPlayerItemBinding: DefaultPlayerItemBinding
    ) : RecyclerView.ViewHolder(defaultPlayerItemBinding.root) {
        fun bind(defaultPlayer: DefaultPlayer) {
            defaultPlayer.setText(defaultPlayerItemBinding.defaultPlayerName)
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<DefaultPlayer>() {

        override fun areItemsTheSame(oldItem: DefaultPlayer, newItem: DefaultPlayer) =
            oldItem.sameId(newItem)

        override fun areContentsTheSame(oldItem: DefaultPlayer, newItem: DefaultPlayer) =
            oldItem.sameItem(newItem)
    }
}