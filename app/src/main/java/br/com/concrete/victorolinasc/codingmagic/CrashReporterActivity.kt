package br.com.concrete.victorolinasc.codingmagic

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import br.com.concrete.victorolinasc.autoinit.AutoInit
import kotterknife.bindView

class CrashReporterActivity : AppCompatActivity() {

    val crashClick by bindView<Button>(R.id.crash_click)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crashreporter)

        crashClick.setOnClickListener {
            throw IllegalStateException("Raising...")
        }
    }
}