package br.com.concrete.victorolinasc.crashreport

import com.orhanobut.hawk.Hawk
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Automatically encrypted local preferences used as a singleton with property access
 */
object LocalStorage {
    var exceptionCount: Int by hawkDelegate(0)
}

private fun <T> hawkDelegate(defaultValue: T) = HawkDelegate(defaultValue)

/**
 * Thin wrapper over Hawk for a cached secure preferences
 */
class HawkDelegate<T>(val defaultValue: T) : ReadWriteProperty<Any, T> {

    private var inMemoryValue: T? = null

    override fun getValue(thisRef: Any, property: KProperty<*>): T =
            inMemoryValue?.let { inMemoryValue } ?: Hawk.get(property.name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        Hawk.put(property.name, value)
        inMemoryValue = value
    }
}
