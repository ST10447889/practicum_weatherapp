package com.st10447889.practicum_weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InputActivity : AppCompatActivity() {
    private lateinit var etDay: EditText
    private lateinit var etMorning: EditText
    private lateinit var etAfternoon: EditText
    private lateinit var etNotes: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonDisplay: Button

    private var dayList = mutableListOf<Int>()
    private var morningList = mutableListOf<Float>()
    private var afternoonList = mutableListOf<Float>()
    private var notesList = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input)


        etDay = findViewById(R.id.etDay)
        etMorning = findViewById(R.id.etMorning)
        etAfternoon = findViewById(R.id.etAfternoon)
        etNotes = findViewById(R.id.etNotes)
        buttonSave = findViewById(R.id.buttonSave)
        buttonClear = findViewById(R.id.buttonClear)
        buttonDisplay = findViewById(R.id.buttonDisplay)

        buttonClear.setOnClickListener{
            etDay.setText("")
            etMorning.setText("")
            etAfternoon.setText("")
            etNotes.setText("")
        }
        buttonSave.setOnClickListener{
            val realday = etDay.text.toString()
            val realmorning = etMorning.text.toString()
            val realafternoon = etAfternoon.text.toString()
            val realnotes = etNotes.text.toString()
            if (realday.isNotEmpty()&& realmorning.isNotEmpty()&&realafternoon.isNotEmpty()){
                try {
                    dayList.add(realday.toInt())
                    morningList.add(realmorning.toFloat())
                    afternoonList.add(realafternoon.toFloat())
                    notesList.add(realnotes)
                    etDay.setText("")
                    etMorning.setText("")
                    etAfternoon.setText("")
                    etNotes.setText("")
                        }
                    catch (_: NumberFormatException){

                    }
            }
        }
        buttonDisplay.setOnClickListener{
            val intent2= Intent( this,DisplayActivity::class.java)
            intent2.putExtra("dayArray",dayList.toTypedArray())
            intent2.putExtra("morningArray",morningList.toTypedArray())
            intent2.putExtra("afternoonArray",afternoonList.toTypedArray())
            intent2.putExtra("notesArray",notesList.toTypedArray())
            startActivity(intent2)


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fun calculateAverageTemperature(temperatures: List<Double>): Double {
            if (temperatures.isEmpty()) return 0.0 // Handle empty list

            val sum = temperatures.sum()
            return sum / temperatures.size
        }

        fun main() {
            val weeklyTemperatures = listOf(20.5, 22.0, 18.5, 23.5, 21.0, 19.0, 24.0)
            val averageTemperature = calculateAverageTemperature(weeklyTemperatures)

            println("The average temperature for the week is: $averageTemperature")
        }
    }
}

private fun add() {
    TODO("Not yet implemented")
}
