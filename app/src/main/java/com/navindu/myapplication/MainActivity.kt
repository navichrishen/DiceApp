package com.navindu.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var gameScore =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val aboutBt = findViewById<Button>(R.id.android.about)
        aboutBt()
        newGameBt()
        rules()

    }
    fun newGameBt(){
        newgame.setOnClickListener {
            startActivity(Intent(this,GameActivity::class.java))
        }
    }
    fun aboutBt(){
        aboutBt.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("20200935 Navindu")
            builder.setMessage("I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students."+
                    "The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.")
            builder.setNeutralButton("Cancel") { dialog, id -> dialog.cancel()}
            builder.show()
        }
    }
    fun rules(){
        rules.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Rules of Game")
            builder.setMessage("• You are competing against the Device \n" +
                    "• Both players throws 5 dice at same time \n" +
                    "• First player to reach '101' score wins " +
                    "• You can setup custom score\n" +
                    "• After a roll, each player may either score it or take up to 2 re-rolls \n" +
                    "• You can re-roll all dice or select any of the dice to keep and re-roll \n" +
                    "• You can score in anytime during the re-rolls \n" +
                    "• After both players score their rolls, the procedure is repeated until one of the players reach 101 or more points by summing all of their scores.\n" +
                    "• If both players reach 101 or more with the same number of attempts the player with the highest score wins. ")
            builder.setNeutralButton("I Understand") { dialog, id -> dialog.cancel()}
            builder.show()
        }
    }



}

