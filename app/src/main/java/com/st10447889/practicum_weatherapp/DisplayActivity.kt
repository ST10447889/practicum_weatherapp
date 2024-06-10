package com.st10447889.practicum_weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayActivity : AppCompatActivity() {
    private lateinit var tvDay: TextView
    private lateinit var tvMorning: TextView
    private lateinit var tvAfternoon: TextView
    private lateinit var tvNotes: TextView
    private lateinit var buttonBack : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display)
        tvDay = findViewById(R.id.tvDay)
        tvMorning = findViewById(R.id.tvMorning)
        tvAfternoon = findViewById(R.id.tvAfternoon)
        tvNotes = findViewById(R.id.tvNotes)
        buttonBack = findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            finish()
        }
        val day = intent.getStringExtra("day")
        val morning = intent.getStringExtra("morning")
        val afternoon = intent.getStringExtra("afternoon")
        val notes = intent.getStringExtra("notes")
        tvDay.text = day
        tvMorning.text = morning
        tvAfternoon.text = afternoon

        var dayed = StringBuilder()
        if (day != null) {
            for((index, day) in day.withIndex()){
                dayed.append("Day: ${index} : $day")
            }
        }
        var arraymorning = StringBuilder()
        if (morning != null) {
            for((index, time) in morning.withIndex()){
                dayed.append("time: ${index} : $time")
            }
        }
        var arrayafternoon = StringBuilder()
        if (afternoon != null) {
            for((index, time) in afternoon.withIndex()){
                dayed.append("time: ${index} : $time")
            }
        }
        var arraynotes = StringBuilder()
        if (notes != null) {
            for((index, time) in notes.withIndex()){
                dayed.append("time: ${index} : $time")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}