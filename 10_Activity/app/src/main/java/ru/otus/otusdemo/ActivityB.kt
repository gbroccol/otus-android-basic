package ru.otus.otusdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActivityB : AppCompatActivity() {

    private val buttonOpenActivityC by lazy { findViewById<Button>(R.id.buttonOpenActivityC) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        // По клику на кнопку “Open ActivityC” запустите ActivityC
        // в том же стеке, в котором расположена ActivityB
        buttonOpenActivityC.setOnClickListener {
            val intent = Intent(this, ActivityC::class.java)
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "onNewIntent (ActivityB)", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Toast.makeText(this, "Кнопка бэк была нажата (ActivityB)", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "ActivityB onDestroy", Toast.LENGTH_SHORT).show()
    }
}