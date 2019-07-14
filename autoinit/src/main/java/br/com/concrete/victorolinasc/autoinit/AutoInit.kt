package br.com.concrete.victorolinasc.autoinit

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import br.com.concrete.victorolinasc.crashreport.CrashReport
import br.com.concrete.victorolinasc.fulllifecycle.FullcycleProvider
import java.lang.ref.WeakReference

const val TAG = "AutoInit"

object AutoInit {

    lateinit var appRef: WeakReference<Application>

    fun init(ctx: Context) {

        Log.i(TAG, "Initializing AutoInit :)")

        val app = ctx.applicationContext as Application
        appRef = WeakReference(app)

        FullcycleProvider.init(app)
        CrashReport.init(app)
    }

    fun appToast(msg: String) {
        Toast.makeText(FullcycleProvider.getCurrentActivity(), msg, Toast.LENGTH_LONG).show()
    }
}