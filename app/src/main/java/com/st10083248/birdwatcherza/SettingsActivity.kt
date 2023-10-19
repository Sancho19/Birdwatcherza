package com.st10083248.birdwatcherza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.st10083248.birdwatcherza.R.id.rgMetricSystem

class SettingsActivity : AppCompatActivity() {

    private lateinit var rbMiles: RadioButton
    private lateinit var rbKilometers: RadioButton
    private lateinit var etxtMaxDistance: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        rbMiles = findViewById(R.id.rbMiles)
        rbKilometers = findViewById(R.id.rbKilometers)
        etxtMaxDistance = findViewById(R.id.etxtMaxDistance)

        etxtMaxDistance.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // Handle the user's input for the maximum distance here
                val maxDistance = s.toString()
            }
        })
        val radioGroup = findViewById<RadioGroup>(rgMetricSystem)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbMiles -> {
                    // Handle the selection of miles
                }
                R.id.rbKilometers -> {
                    // Handle the selection of kilometers
                }
            }
        }
    }
}