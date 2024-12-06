package com.example.activities

class TipCalculator(_procent: Int, _summa: Double) {
    val procent:Int = _procent
    val summa:Double = _summa
    fun GetTotal():Double
    {
        return summa + (summa * procent / 100)
    }
}