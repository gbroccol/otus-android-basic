package ru.otus.otusdemo

import android.app.Application

class OtusApplication: Application() {

    val id = "Im from Application"

    // during init app (running)
    override fun onCreate() {
        super.onCreate()
    }
}