package com.example.zhoraapplication.game.presentation.playercreation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zhoraapplication.App
import com.example.zhoraapplication.ProvideViewModel
import com.example.zhoraapplication.core.presentation.BaseFragment
import com.example.zhoraapplication.databinding.FragmentAddPlayerBinding
import com.example.zhoraapplication.game.data.playercreation.DefaultPlayer

class PlayerCreationFragment : BaseFragment<FragmentAddPlayerBinding>() {

    private lateinit var viewModel: PlayerCreationViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlayerCreationAdapter

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddPlayerBinding = FragmentAddPlayerBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity?.application as ProvideViewModel).provide()
        recyclerView = binding.playerList

        setRecyclerView()
        setClickListeners()

        viewModel.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun setRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = PlayerCreationAdapter()
        recyclerView.adapter = adapter
    }

    private fun setClickListeners() {
        binding.addPlayerButton.setOnClickListener {
            viewModel.addPlayer(DefaultPlayer(0, binding.playerName.text.toString()))
        }
    }
}