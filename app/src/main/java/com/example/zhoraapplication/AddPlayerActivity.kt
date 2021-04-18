package com.example.zhoraapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class AddPlayerActivity : AppCompatActivity() {
    lateinit var playerText: EditText
    lateinit var playerList:ListView
    lateinit var addPlayerButton: Button
    lateinit var adapter: Adapter
    lateinit var roundActivityButton: Button
    private val playerArray:ArrayList<Player> = ArrayList()
    private val playerName:ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)
        playerList = findViewById(R.id.playerList)
        addPlayerButton = findViewById(R.id.addPlayerButton)
        playerText = findViewById(R.id.playerText)
        roundActivityButton = findViewById(R.id.roundActivity)
        addPlayerButton.setOnClickListener {
            if (playerText.text.toString().isEmpty()){
                Toast.makeText(this, R.string.enterYourName, Toast.LENGTH_SHORT).show()
            }else{
                playerArray.add(Player(playerText.text.toString(),0,0))
                playerName.add(playerText.text.toString())
                adapter = ArrayAdapter(this,R.layout.row,playerName)
                playerList.adapter = adapter as ArrayAdapter<*>
                playerText.text.clear()
            }
        }

        playerList.onItemClickListener = AdapterView.OnItemClickListener{
            _, _, position, _ ->
            playerArray.removeAt(position)
            playerName.removeAt(position)
            (adapter as ArrayAdapter<*>).notifyDataSetChanged()
        }

        roundActivityButton.setOnClickListener {
            if (playerArray.size < 2) {
                Toast.makeText(this, R.string.need2Players, Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, RoundActivity::class.java)
                intent.putExtra("PlayersList", playerArray)
                startActivity(intent)
                finish()
            }
        }
    }
}