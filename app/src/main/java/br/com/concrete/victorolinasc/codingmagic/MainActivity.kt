package br.com.concrete.victorolinasc.codingmagic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotterknife.bindView

class MainActivity : AppCompatActivity() {

    val greeterName by bindView<EditText>(R.id.greeter_name)
    val hitIt by bindView<Button>(R.id.hit_it)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
