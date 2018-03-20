package br.com.concrete.victorolinasc.proxy

import android.content.Context
import android.widget.Toast
import java.lang.reflect.Proxy

object GreeterProxy {

    fun <T> createGreeter(greeterApi: Class<out T>, currentContext: Context): T {

        if (!greeterApi.isInterface) throw IllegalArgumentException("Must be an interface!!")

        @Suppress("UNCHECKED_CAST")
        return Proxy.newProxyInstance(
                greeterApi.classLoader,
                arrayOf(greeterApi)
        ) { _, method, args ->
            // proxy, method, args

            // proxy: the object we call the method
            // method: the method invoked
            // args: args of the the method

            Toast.makeText(
                    currentContext,
                    "${method.name.capitalize()} ${args[0] as String}",
                    Toast.LENGTH_LONG
            ).show()

        } as T
    }
}