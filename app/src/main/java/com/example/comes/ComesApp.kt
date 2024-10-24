package com.example.comes

import android.app.Application

class ComesApp : Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: ComesApp
            private set
    }
}