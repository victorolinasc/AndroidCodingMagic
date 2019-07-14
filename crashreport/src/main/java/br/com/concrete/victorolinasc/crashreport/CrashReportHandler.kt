package br.com.concrete.victorolinasc.crashreport

import android.util.Log

const val TAG = "CrashReportHandler"

class CrashReportHandler : Thread.UncaughtExceptionHandler {

    private val handler = Thread.getDefaultUncaughtExceptionHandler()

    override fun uncaughtException(t: Thread?, e: Throwable) {

        // Reads an encrypted value, adds one to current value and re-encrypts in local persistence
        LocalStorage.exceptionCount++

        val msg = "Deu ruim... o chefe apareceu!\n\n" +
                "Thread: $t\n" +
                "Exception message: ${e.message}\n" +
                "Exception count: ${LocalStorage.exceptionCount}"

        Log.e(TAG, msg, e)
        handler.uncaughtException(t, e)
    }
}