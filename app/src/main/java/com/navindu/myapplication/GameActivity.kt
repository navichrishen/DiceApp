package com.navindu.myapplication

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*


class GameActivity : AppCompatActivity() {

    private var dice1 = 0
    private var dice2 = 0
    private var dice3 = 0
    private var dice4 = 0
    private var dice5 = 0

    private var dice6 = 0
    private var dice7 = 0
    private var dice8 = 0
    private var dice9 = 0
    private var dice10 = 0

    private var totalScorePlayer = 0
    private var totalScoreComputer = 0

    var rollCount = 0

    private var dice1temp = 0
    private var dice2temp = 0
    private var dice3temp = 0
    private var dice4temp = 0
    private var dice5temp = 0

    private val playerScore = ArrayList<Int>()
    private val computerScore = ArrayList<Int>()

    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView
    private lateinit var diceImage3: ImageView
    private lateinit var diceImage4: ImageView
    private lateinit var diceImage5: ImageView

    private var dice1Clicked = false
    private var dice2Clicked = false
    private var dice3Clicked = false
    private var dice4Clicked = false
    private var dice5Clicked = false

    private var previousRolls = intArrayOf(dice1temp,dice2temp,dice3temp,dice4temp,dice5temp)

    private var wins = 0

    private var gameScore = 101

    companion object{
         var humanWins = 0
        var computerWins = 0


    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        currentwins.text = "H: $humanWins / C: $computerWins"
        diceImage1 = findViewById<ImageView>(R.id.d1)
        diceImage2 = findViewById<ImageView>(R.id.d2)
        diceImage3 = findViewById<ImageView>(R.id.d3)
        diceImage4 = findViewById<ImageView>(R.id.d4)
        diceImage5 = findViewById<ImageView>(R.id.d5)

        scoreBt.isEnabled = false
        rerollBt.isEnabled = false


        rollBt.setOnClickListener {

            rollDicePlayer()
            rollDiceComputer()
            rollBt.isEnabled = false
            scoreBt.isEnabled = true
            rerollBt.isEnabled = true
            playerScore.sum()
            computerScore.sum()

        }
        scoreBt.setOnClickListener {

            playerScore()
            computerScore()
            rollBt.isEnabled = true
            scoreBt.isEnabled = false

        }
        scoresetBt.setOnClickListener {

            customScoreSet()

        }
        rerollBt.setOnClickListener {

            reRolls()

            rollCount += 1
            if (rollCount == 2) {
                diceBoolean()
                rollBt.isEnabled = true
                rerollBt.isEnabled = false
                rollCount = 0
                playerScore()
                computerScore()
                scoreBt.isEnabled = false
            }
        }

    }
    private fun rollDicePlayer() {

        diceRandomPlayer()

        when (dice1) {
            1 -> diceImage1.setImageResource(R.drawable.face1)
            2 -> diceImage1.setImageResource(R.drawable.face2)
            3 -> diceImage1.setImageResource(R.drawable.face3)
            4 -> diceImage1.setImageResource(R.drawable.face4)
            5 -> diceImage1.setImageResource(R.drawable.face5)
            6 -> diceImage1.setImageResource(R.drawable.face6)
        }

        when (dice2) {
            1 -> diceImage2.setImageResource(R.drawable.face1)
            2 -> diceImage2.setImageResource(R.drawable.face2)
            3 -> diceImage2.setImageResource(R.drawable.face3)
            4 -> diceImage2.setImageResource(R.drawable.face4)
            5 -> diceImage2.setImageResource(R.drawable.face5)
            6 -> diceImage2.setImageResource(R.drawable.face6)
        }
        when (dice3) {
            1 -> diceImage3.setImageResource(R.drawable.face1)
            2 -> diceImage3.setImageResource(R.drawable.face2)
            3 -> diceImage3.setImageResource(R.drawable.face3)
            4 -> diceImage3.setImageResource(R.drawable.face4)
            5 -> diceImage3.setImageResource(R.drawable.face5)
            6 -> diceImage3.setImageResource(R.drawable.face6)

        }

        when (dice4) {
            1 -> diceImage4.setImageResource(R.drawable.face1)
            2 -> diceImage4.setImageResource(R.drawable.face2)
            3 -> diceImage4.setImageResource(R.drawable.face3)
            4 -> diceImage4.setImageResource(R.drawable.face4)
            5 -> diceImage4.setImageResource(R.drawable.face5)
            6 -> diceImage4.setImageResource(R.drawable.face6)
        }

        when (dice5) {
            1 -> diceImage5.setImageResource(R.drawable.face1)
            2 -> diceImage5.setImageResource(R.drawable.face2)
            3 -> diceImage5.setImageResource(R.drawable.face3)
            4 -> diceImage5.setImageResource(R.drawable.face4)
            5 -> diceImage5.setImageResource(R.drawable.face5)
            6 -> diceImage5.setImageResource(R.drawable.face6)

        }
        diceSelect()

        println(dice1temp)
        println(dice2temp)

        println(dice3temp)

        println(dice4temp)

        println(dice5temp)


    }
    private fun diceSelect(){
        diceImage1.setOnClickListener {
            if(diceImage1.isPressed){
                previousRolls[dice1temp] = dice1
                dice1Clicked = true
                println("works")
            }
        }
        diceImage2.setOnClickListener {
            if(diceImage2.isPressed){
                previousRolls[dice2temp] = dice1

                dice2Clicked = true
                println("works")

            }
            else{
                dice2Clicked = false
            }
        }

        diceImage3.setOnClickListener {
            if(diceImage3.isPressed){
                previousRolls[dice3temp] = dice1

                dice3Clicked = true
                println("works")

            }
            else{
                dice3Clicked = false
            }

        }
        diceImage4.setOnClickListener {
            if(diceImage4.isPressed){
                previousRolls[dice4temp] = dice1

                dice4Clicked = true
                println("works")

            }
            else{
                dice4Clicked = false
            }
        }
        diceImage5.setOnClickListener {
            if(diceImage5.isPressed){
                previousRolls[dice5temp] = dice1

                dice5Clicked = true
                println("works")
            }
            else{
                dice5Clicked = false
            }
        }
    }

    // Generating random numbers from 1 to 6
    private fun randoms(): Int {
        return (1..6).random()
    }

    // Assigning random values for each dice
    private fun diceRandomPlayer(){
        dice1 = randoms()
        dice2 = randoms()
        dice3 = randoms()
        dice4 = randoms()
        dice5 = randoms()

    }
    private fun diceRandomComputer(){
        dice6 = randoms()
        dice7 = randoms()
        dice8 = randoms()
        dice9 = randoms()
        dice10 = randoms()
    }
    private fun diceBoolean(){
        dice1Clicked = false
        dice2Clicked = false
        dice3Clicked = false
        dice4Clicked = false
        dice5Clicked = false

    }




    private fun rollDiceComputer() {
        diceRandomComputer()

        val diceImage6 = findViewById<ImageView>(R.id.d6)
        val diceImage7 = findViewById<ImageView>(R.id.d7)
        val diceImage8 = findViewById<ImageView>(R.id.d8)
        val diceImage9 = findViewById<ImageView>(R.id.d9)
        val diceImage10 = findViewById<ImageView>(R.id.d10)

        when (dice6) {
            1 -> diceImage6.setImageResource(R.drawable.face1)
            2 -> diceImage6.setImageResource(R.drawable.face2)
            3 -> diceImage6.setImageResource(R.drawable.face3)
            4 -> diceImage6.setImageResource(R.drawable.face4)
            5 -> diceImage6.setImageResource(R.drawable.face5)
            6 -> diceImage6.setImageResource(R.drawable.face6)
        }
        when (dice7) {
            1 -> diceImage7.setImageResource(R.drawable.face1)
            2 -> diceImage7.setImageResource(R.drawable.face2)
            3 -> diceImage7.setImageResource(R.drawable.face3)
            4 -> diceImage7.setImageResource(R.drawable.face4)
            5 -> diceImage7.setImageResource(R.drawable.face5)
            6 -> diceImage7.setImageResource(R.drawable.face6)
        }
        when (dice8) {
            1 -> diceImage8.setImageResource(R.drawable.face1)
            2 -> diceImage8.setImageResource(R.drawable.face2)
            3 -> diceImage8.setImageResource(R.drawable.face3)
            4 -> diceImage8.setImageResource(R.drawable.face4)
            5 -> diceImage8.setImageResource(R.drawable.face5)
            6 -> diceImage8.setImageResource(R.drawable.face6)
        }
        when (dice9) {
            1 -> diceImage9.setImageResource(R.drawable.face1)
            2 -> diceImage9.setImageResource(R.drawable.face2)
            3 -> diceImage9.setImageResource(R.drawable.face3)
            4 -> diceImage9.setImageResource(R.drawable.face4)
            5 -> diceImage9.setImageResource(R.drawable.face5)
            6 -> diceImage9.setImageResource(R.drawable.face6)
        }
        when (dice10) {
            1 -> diceImage10.setImageResource(R.drawable.face1)
            2 -> diceImage10.setImageResource(R.drawable.face2)
            3 -> diceImage10.setImageResource(R.drawable.face3)
            4 -> diceImage10.setImageResource(R.drawable.face4)
            5 -> diceImage10.setImageResource(R.drawable.face5)
            6 -> diceImage10.setImageResource(R.drawable.face6)
        }

    }

    private fun computerScore() {
        val score = findViewById<TextView>(R.id.computerscore)
        totalScoreComputer = dice6 + dice7 + dice8 + dice9 + dice10
        computerScore.add(totalScoreComputer)
        score.text = computerScore.sum().toString()
        if (computerScore.sum() > playerScore.sum()) {
            if (computerScore.sum() >= gameScore) {
                val winColor = Color.RED
                val looseTxt = "You Loose !!"
                val looseImage = R.drawable.sad
                customDialog(winColor, looseTxt, looseImage)
                computerWins++

            }
        } else {
            println("sdasdasdsadasdsa")
        }

    }



    private fun disableButtons() {
        rollBt.isEnabled = false
        scoresetBt.isEnabled = false
        rerollBt.isEnabled = false
        scoreBt.isEnabled = false
    }

    private fun customScoreSet() {

        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.custom_score, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.customScore)
        with(builder) {
            setTitle("Set your Custom Score")
            setPositiveButton("Set") { dialog, which ->
                gameScore = editText.text.toString().toInt()
                println(gameScore)

            }
            setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
            }

            setView(dialogLayout)
            show()
        }
    }

    private fun customDialog(color: Int, state: String, winImage: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        val returnBt = dialog.findViewById<Button>(R.id.returnBt)
        val winnerTxt = dialog.findViewById<TextView>(R.id.winnerTxt)
        val faceState = dialog.findViewById<ImageView>(R.id.winimage)
        winnerTxt.setTextColor(color);
        winnerTxt.text = state
        faceState.setImageResource(winImage)
        returnBt.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }


    private fun reRolls(){
        if(dice1Clicked) {
            dice1 = previousRolls[0]
        }else{
            dice1 = randoms()
        }
        if(dice2Clicked){
            dice2 = previousRolls[1]

        }else{
            dice2 = randoms()
        }
        if(dice3Clicked){
            dice3 = previousRolls[2]

        }else{
            dice3 = randoms()
        }
        if(dice4Clicked){
            dice4 = previousRolls[3]

        }else{
            dice4 = randoms()
        }
        if(dice5Clicked){
            dice5 = previousRolls[4]

        }else{
            dice5 = randoms()
        }
        when (dice1) {
            1 -> diceImage1.setImageResource(R.drawable.face1)
            2 -> diceImage1.setImageResource(R.drawable.face2)
            3 -> diceImage1.setImageResource(R.drawable.face3)
            4 -> diceImage1.setImageResource(R.drawable.face4)
            5 -> diceImage1.setImageResource(R.drawable.face5)
            6 -> diceImage1.setImageResource(R.drawable.face6)
        }

        when (dice2) {
            1 -> diceImage2.setImageResource(R.drawable.face1)
            2 -> diceImage2.setImageResource(R.drawable.face2)
            3 -> diceImage2.setImageResource(R.drawable.face3)
            4 -> diceImage2.setImageResource(R.drawable.face4)
            5 -> diceImage2.setImageResource(R.drawable.face5)
            6 -> diceImage2.setImageResource(R.drawable.face6)
        }

        when (dice3) {
            1 -> diceImage3.setImageResource(R.drawable.face1)
            2 -> diceImage3.setImageResource(R.drawable.face2)
            3 -> diceImage3.setImageResource(R.drawable.face3)
            4 -> diceImage3.setImageResource(R.drawable.face4)
            5 -> diceImage3.setImageResource(R.drawable.face5)
            6 -> diceImage3.setImageResource(R.drawable.face6)
        }

        when (dice4) {
            1 -> diceImage4.setImageResource(R.drawable.face1)
            2 -> diceImage4.setImageResource(R.drawable.face2)
            3 -> diceImage4.setImageResource(R.drawable.face3)
            4 -> diceImage4.setImageResource(R.drawable.face4)
            5 -> diceImage4.setImageResource(R.drawable.face5)
            6 -> diceImage4.setImageResource(R.drawable.face6)
        }

        when (dice5) {
            1 -> diceImage5.setImageResource(R.drawable.face1)
            2 -> diceImage5.setImageResource(R.drawable.face2)
            3 -> diceImage5.setImageResource(R.drawable.face3)
            4 -> diceImage5.setImageResource(R.drawable.face4)
            5 -> diceImage5.setImageResource(R.drawable.face5)
            6 -> diceImage5.setImageResource(R.drawable.face6)
        }
        println(dice1temp)
        println(dice2temp)

        println(dice3temp)

        println(dice4temp)

        println(dice5temp)


    }

    private fun playerScore() {
        val score = findViewById<TextView>(R.id.playerscore)

        totalScorePlayer = dice1 + dice2 + dice3 + dice4 + dice5
        playerScore.add(totalScorePlayer)
        score.text = playerScore.sum().toString()
        if (playerScore.sum() > computerScore.sum()) {
            if (playerScore.sum() >= gameScore) {
                val winColor = ContextCompat.getColor(this, R.color.green)
                val winnerTxt = "You Won !!"
                val winImage = R.drawable.happy
                customDialog(winColor, winnerTxt, winImage)
                humanWins++

            }
        } else if(playerScore.sum() == computerScore.sum()){
            // its a tie
        }
    }



}
