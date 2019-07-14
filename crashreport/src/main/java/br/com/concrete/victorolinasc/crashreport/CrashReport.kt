package br.com.concrete.victorolinasc.crashreport

import android.app.Application
import com.orhanobut.hawk.Hawk

object CrashReport {

    fun init(app: Application) {
        Hawk.init(app).build()
        Thread.setDefaultUncaughtExceptionHandler(CrashReportHandler())
    }
}