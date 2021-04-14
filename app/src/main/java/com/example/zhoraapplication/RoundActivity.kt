package com.example.zhoraapplication


import MyListView
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class RoundActivity : AppCompatActivity() {
    var roundNumber = 1
    lateinit var roundTextView: TextView
    lateinit var nextRoundButton: Button
    lateinit var playerList: ListView
    lateinit var adapter: MyListView
    var playerArray = ArrayList<Player>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round)
        playerList = findViewById(R.id.playerList)
        roundTextView = findViewById(R.id.roundTextView)
        var intent = intent
        playerArray = intent.extras?.getParcelableArrayList<Player>("PlayersList")!!
        adapter = MyListView(this, playerArray)
        playerList.adapter = adapter
        nextRoundButton = findViewById(R.id.nextRoundButton)
        nextRoundButton.setOnClickListener {
            roundNumber++
            for (i in playerArray) {
                i.points = i.points + i.pointsToPlus
                i.pointsToPlus = 0
            }
            if (roundNumber == playerArray.size + 1) {
                onPause()
                val intent = Intent(this, ResultActivity::class.java)
                playerArray.sortBy { it.points }
                intent.putExtra("PlayersList", playerArray)
                startActivity(intent)
                finish()
            }
                roundTextView.text = "Round $roundNumber"
                adapter = MyListView(this, playerArray)
                playerList.adapter = adapter
            }
        }
    }
