package ru.otus.otusdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActivityC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val buttonA = findViewById<Button>(R.id.buttonToActivityA)
        buttonA.setOnClickListener {
            val intent = Intent(applicationContext, ActivityA::class.java)
            startActivity(intent)
        }

        val buttonC = findViewById<Button>(R.id.buttonToActivityC)
        buttonC.setOnClickListener {
            val intent = Intent(applicationContext, ActivityC::class.java)
            startActivity(intent)
        }


        val buttonD = findViewById<Button>(R.id.buttonToActivityD)
        buttonD.setOnClickListener {
            val intent = Intent(applicationContext, ActivityD::class.java)
            startActivity(intent)
        }

        val buttonCloseStack = findViewById<Button>(R.id.buttonCloseStack)
        buttonCloseStack.setOnClickListener {

        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "onNewIntent", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "Кнопка бэк была нажата", Toast.LENGTH_SHORT).show()
    }
}