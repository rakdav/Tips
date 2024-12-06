package com.example.activities

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun calc_isCorrect() {
        val calc1=TipCalculator(5,200.0)
        assertEquals(210.0, calc1.GetTotal(),0.01)
        val calc2=TipCalculator(10,200.0)
        assertEquals(220.0, calc2.GetTotal(),0.01)
        val calc3=TipCalculator(15,200.0)
        assertEquals(230.0, calc3.GetTotal(),0.01)
    }
}