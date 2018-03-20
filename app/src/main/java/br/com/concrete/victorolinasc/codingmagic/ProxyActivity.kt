package br.com.concrete.victorolinasc.codingmagic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.concrete.victorolinasc.proxy.GreeterProxy
import kotterknife.bindView

/**
 * PURE Interface that will be dynamically implemented.
 */
interface Greeter {

    fun hello(name: String)

    fun howdy(name: String)
}


class ProxyActivity : AppCompatActivity() {

    // greeter edit field
    private val greeterName by bindView<EditText>(R.id.greeter_name)

    // Buttons
    private val helloClick by bindView<Button>(R.id.hello_click)
    private val howdyClick by bindView<Button>(R.id.howdy_click)

    // Proxy
    private val proxy = GreeterProxy.createGreeter(Greeter::class.java, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proxy)

        helloClick.setOnClickListener {
            // Calling "hello" method in the proxy
            proxy.hello(greeterName.text.toString())
        }

        howdyClick.setOnClickListener {
            // Calling "howdy" method in the proxy
            proxy.howdy(greeterName.text.toString())
        }
    }
}
