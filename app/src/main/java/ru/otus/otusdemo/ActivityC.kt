package ru.otus.otusdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActivityC : AppCompatActivity() {

    private val buttonOpenActivityA by lazy { findViewById<Button>(R.id.buttonOpenActivityA) }
    private val buttonOpenActivityD by lazy { findViewById<Button>(R.id.buttonOpenActivityD) }
    private val buttonCloseActivityC by lazy { findViewById<Button>(R.id.buttonCloseActivityC) }
    private val buttonCloseStack by lazy { findViewById<Button>(R.id.buttonCloseStack) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        // По клику на кнопку “Open ActivityA” запустите ActivityA, таким образом, чтобы мы попали
        // на существующий экземпляр ActivityA и у него был вызван метод onNewIntent, независимо от
        // того находится ActivityA наверху своего стека или нет
        buttonOpenActivityA.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }

        // По клику на кнопку “Open ActivityD” запустите ActivityD в том же стеке, где расположены
        // ActivityB и ActivityC, при этом завершите все предыдущие Activity, которые находятся
        // в текущем стеке
        buttonOpenActivityD.setOnClickListener {
            val intent = Intent(this, ActivityD::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        // По клику на кнопку “CloseActivityC”, завершите ActivityC, и перейдите на предыдущий экран в стеке
        buttonCloseActivityC.setOnClickListener {
            finish()
        }

        // По клику на кнопку “Close Stack” завершите текущий стек, в котором находятся
        // ActivityB и ActivityC, и перейдите на ActivityA
        buttonCloseStack.setOnClickListener {
            finishAffinity()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "onNewIntent (ActivityC)", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Toast.makeText(this, "Кнопка бэк была нажата (ActivityC)", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "ActivityC onDestroy", Toast.LENGTH_SHORT).show()
    }
}