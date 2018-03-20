package br.com.concrete.victorolinasc.crashreport

import android.util.Log
import br.com.concrete.victorolinasc.fulllifecycle.FullcycleProvider

const val TAG = "CrashReportHandler"

class CrashReportHandler : Thread.UncaughtExceptionHandler {

    private val handler = Thread.getDefaultUncaughtExceptionHandler()

    override fun uncaughtException(t: Thread?, e: Throwable?) {

        // Reads an encrypted value, adds one to current value and re-encrypts in local persistence
        LocalStorage.exceptionCount++

        val msg = "Something is wrong!!! \n\n" +
                "Current activity: ${FullcycleProvider.getCurrentActivity()!!.localClassName}\n" +
                "Current thread: $t\n" +
                "Exception count: ${LocalStorage.exceptionCount}"

        Log.e(TAG, msg, e)

        handler.uncaughtException(t, e)
    }
}