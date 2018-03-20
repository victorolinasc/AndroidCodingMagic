package br.com.concrete.victorolinasc.crashreport

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun testLocalStorage() {
        LocalStorage.exceptionCount++
    }
}
