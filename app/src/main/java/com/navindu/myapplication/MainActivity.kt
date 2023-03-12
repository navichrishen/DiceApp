package com.navindu.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val aboutBt = findViewById<Button>(R.id.android.about)
        aboutBt()
        newGameBt()
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


}

