package ru.otus.otusdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActivityA : AppCompatActivity() {

    private val buttonOpenActivityB by lazy { findViewById<Button>(R.id.buttonOpenActivityB) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        // По клику на кнопку “Open ActivityB” запустите ActivityB (answer is singleInstance)
        // в отдельном стеке, при этом предусмотрите возможность открывать другие Activity
        // в том же стеке где расположена ActivityA
        buttonOpenActivityB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK) // ?
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "onNewIntent (ActivityA)", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Toast.makeText(this, "Кнопка бэк была нажата (ActivityA)", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "ActivityA onDestroy", Toast.LENGTH_SHORT).show()
    }
}