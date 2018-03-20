package br.com.concrete.victorolinasc.autoinit

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast

object AutoInit {

    lateinit var app: Application

    fun init(ctx: Context) {
        Log.i(AutoInit::class.java.canonicalName, "Initializing AutoInit :)")
        app = ctx.applicationContext as Application
    }

    fun appToast(msg: String) {
        Toast.makeText(app, msg, Toast.LENGTH_LONG).show()
    }
}