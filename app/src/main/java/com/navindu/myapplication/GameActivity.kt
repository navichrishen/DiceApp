package com.navindu.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var dice1 =0;
    private var dice2 =0;
    private var dice3 =0;
    private var dice4 =0;
    private var dice5 =0;

    private var dice6 =0;
    private var dice7 =0;
    private var dice8 =0;
    private var dice9 =0;
    private var dice10 =0;

    //private val playerScore = 0

    private var totalScorePlayer =0;
    private var totalScoreComputer =0;


    private val playerScore = ArrayList<Int>()
    private val computerScore = ArrayList<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        rollBt.setOnClickListener {


            rollDicePlayer()
            rollDiceComputer()
            rollBt.isEnabled=false

        }
        scoreBt.setOnClickListener {
            playerScore()
            computerScore()
            rollBt.isEnabled = true

        }

    }

    // function to roll the dice
    private fun rollDicePlayer(){
        dice1 = randoms()
        dice2 = randoms()
        dice3 = randoms()
        dice4 = randoms()
        dice5  = randoms()





        // random values generated for each die in range of 6


        //val cubeTotal = roll1+roll2+roll3+roll4+roll5
        //dice1Val.add(cubeTotal)


        val diceImage1 = findViewById<ImageView>(R.id.d1)
        val diceImage2 = findViewById<ImageView>(R.id.d2)
        val diceImage3 = findViewById<ImageView>(R.id.d3)
        val diceImage4 = findViewById<ImageView>(R.id.d4)
        val diceImage5 = findViewById<ImageView>(R.id.d5)

        val faceTotal = diceImage1

        //playerScore.add()


        when(dice1){
            1-> diceImage1.setImageResource(R.drawable.face1)
            2-> diceImage1.setImageResource(R.drawable.face2)
            3-> diceImage1.setImageResource(R.drawable.face3)
            4-> diceImage1.setImageResource(R.drawable.face4)
            5-> diceImage1.setImageResource(R.drawable.face5)
            6-> diceImage1.setImageResource(R.drawable.face6)
        }
        when(dice2){
            1-> diceImage2.setImageResource(R.drawable.face1)
            2-> diceImage2.setImageResource(R.drawable.face2)
            3-> diceImage2.setImageResource(R.drawable.face3)
            4-> diceImage2.setImageResource(R.drawable.face4)
            5-> diceImage2.setImageResource(R.drawable.face5)
            6-> diceImage2.setImageResource(R.drawable.face6)
        }
        when(dice3){
            1-> diceImage3.setImageResource(R.drawable.face1)
            2-> diceImage3.setImageResource(R.drawable.face2)
            3-> diceImage3.setImageResource(R.drawable.face3)
            4-> diceImage3.setImageResource(R.drawable.face4)
            5-> diceImage3.setImageResource(R.drawable.face5)
            6-> diceImage3.setImageResource(R.drawable.face6)
        }
        when(dice4){
            1-> diceImage4.setImageResource(R.drawable.face1)
            2-> diceImage4.setImageResource(R.drawable.face2)
            3-> diceImage4.setImageResource(R.drawable.face3)
            4-> diceImage4.setImageResource(R.drawable.face4)
            5-> diceImage4.setImageResource(R.drawable.face5)
            6-> diceImage4.setImageResource(R.drawable.face6)
        }
        when(dice5){
            1-> diceImage5.setImageResource(R.drawable.face1)
            2-> diceImage5.setImageResource(R.drawable.face2)
            3-> diceImage5.setImageResource(R.drawable.face3)
            4-> diceImage5.setImageResource(R.drawable.face4)
            5-> diceImage5.setImageResource(R.drawable.face5)
            6-> diceImage5.setImageResource(R.drawable.face6)
        }

    }
    fun playerScore(){
        val score = findViewById<TextView>(R.id.playerscore)
        totalScorePlayer = dice1+dice2+dice3+dice4+dice5
        score.text = totalScorePlayer.toString()
        playerScore.add(totalScorePlayer)
        winner(40)
    }

    private fun rollDiceComputer(){
        dice6 = randoms()
        dice7 = randoms()
        dice8 = randoms()
        dice9 = randoms()
        dice10  = randoms()
        val diceImage6 = findViewById<ImageView>(R.id.d6)
        val diceImage7 = findViewById<ImageView>(R.id.d7)
        val diceImage8 = findViewById<ImageView>(R.id.d8)
        val diceImage9 = findViewById<ImageView>(R.id.d9)
        val diceImage10 = findViewById<ImageView>(R.id.d10)

        when(dice6){
            1-> diceImage6.setImageResource(R.drawable.face1)
            2-> diceImage6.setImageResource(R.drawable.face2)
            3-> diceImage6.setImageResource(R.drawable.face3)
            4-> diceImage6.setImageResource(R.drawable.face4)
            5-> diceImage6.setImageResource(R.drawable.face5)
            6-> diceImage6.setImageResource(R.drawable.face6)
        }
        when(dice7){
            1-> diceImage7.setImageResource(R.drawable.face1)
            2-> diceImage7.setImageResource(R.drawable.face2)
            3-> diceImage7.setImageResource(R.drawable.face3)
            4-> diceImage7.setImageResource(R.drawable.face4)
            5-> diceImage7.setImageResource(R.drawable.face5)
            6-> diceImage7.setImageResource(R.drawable.face6)
        }
        when(dice8){
            1-> diceImage8.setImageResource(R.drawable.face1)
            2-> diceImage8.setImageResource(R.drawable.face2)
            3-> diceImage8.setImageResource(R.drawable.face3)
            4-> diceImage8.setImageResource(R.drawable.face4)
            5-> diceImage8.setImageResource(R.drawable.face5)
            6-> diceImage8.setImageResource(R.drawable.face6)
        }
        when(dice9){
            1-> diceImage9.setImageResource(R.drawable.face1)
            2-> diceImage9.setImageResource(R.drawable.face2)
            3-> diceImage9.setImageResource(R.drawable.face3)
            4-> diceImage9.setImageResource(R.drawable.face4)
            5-> diceImage9.setImageResource(R.drawable.face5)
            6-> diceImage9.setImageResource(R.drawable.face6)
        }
        when(dice10){
            1-> diceImage10.setImageResource(R.drawable.face1)
            2-> diceImage10.setImageResource(R.drawable.face2)
            3-> diceImage10.setImageResource(R.drawable.face3)
            4-> diceImage10.setImageResource(R.drawable.face4)
            5-> diceImage10.setImageResource(R.drawable.face5)
            6-> diceImage10.setImageResource(R.drawable.face6)
        }

    }
    fun computerScore(){
        val score = findViewById<TextView>(R.id.computerscore)
        totalScoreComputer = dice6+dice7+dice8+dice9+dice10
        score.text = totalScoreComputer.toString()
        winner(40)

    }
//    class RandomVal(private val numSides: Int){
//        fun randomRolls(): Int{
//            return (1.. numSides).random()
//        }
//    }
    fun winner( score:Int){

        if(playerScore.sum()>=score){
            Toast.makeText(this,"You Wins",Toast.LENGTH_LONG).show()
        }else if(computerScore.sum()>=score){
            Toast.makeText(this,"Device Wins ",Toast.LENGTH_LONG).show()
        }else{

        }
    }
private fun randoms(): Int{
        return (1..6).random()
    }


}