package com.example.zhoraapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.colorSpace
import androidx.core.graphics.toColor
import androidx.core.view.get


class ResultActivity : AppCompatActivity() {
    lateinit var playerResultList: ListView
    var playerArray = ArrayList<Player>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        playerResultList = findViewById(R.id.playerResultList)
        val intent = intent
        playerArray = intent.extras?.getParcelableArrayList<Player>("PlayersList")!!
        val data = ArrayList<HashMap<String, String>>()
        for (i in playerArray){
            val hashMap1 = HashMap<String, String>()
            hashMap1["Names"] = i.name.toString()
            hashMap1["Points"] = i.points.toString()
            data.add(hashMap1)
        }

        val adapter = SimpleAdapter(this, data, R.layout.row2, arrayOf("Names", "Points"),
                intArrayOf(android.R.id.text1, android.R.id.text2))
        playerResultList.adapter = adapter
        Toast.makeText(this, "Winner is ${playerArray[0].name}",Toast.LENGTH_LONG).show()
        val finishButton:Button = findViewById(R.id.finishButton)
        finishButton.setOnClickListener {
            val intentFinish = Intent(this, MainActivity::class.java)
            startActivity(intentFinish)
            finish()
        }
    }
}