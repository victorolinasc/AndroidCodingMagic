package br.com.concrete.victorolinasc.proxy

import android.content.Context
import android.widget.Toast
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

object GreeterProxy {

    fun <T> create(api: Class<out T>, currentContext: Context): T {

        @Suppress("UNCHECKED_CAST")
        return Proxy.newProxyInstance(
                api.classLoader,
                arrayOf(api),
                 { _, method, args ->
                     Toast.makeText(
                            currentContext,
                            "Invoked ${method.name} with value ${args[0]}",
                            Toast.LENGTH_LONG
                    ).show()
                }
        ) as T
    }
}