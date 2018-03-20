package br.com.concrete.victorolinasc.codingmagic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import br.com.concrete.victorolinasc.autoinit.AutoInit
import kotterknife.bindView


class AutoInitActivity : AppCompatActivity() {

    val message by bindView<EditText>(R.id.message)
    val toastClick by bindView<Button>(R.id.toast_click)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autoinit)

        toastClick.setOnClickListener {
            // IT IS MAGIC!!!
            // Will "toast to magic" without passing "this" as a context, only the string
            AutoInit.appToast("Magic toast message: ${message.text}")
        }
    }
}