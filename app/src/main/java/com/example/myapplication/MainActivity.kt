package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var sum = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Find all views
        val sumTextView = findViewById<TextView>(R.id.totalSum)
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val imageView1 = findViewById<ImageView>(R.id.imageView6)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val imageView2 = findViewById<ImageView>(R.id.imageView7)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val imageView3 = findViewById<ImageView>(R.id.imageView8)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val checkBox5 = findViewById<CheckBox>(R.id.checkBox5)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val checkBox6 = findViewById<CheckBox>(R.id.checkBox6)
        val imageView6 = findViewById<ImageView>(R.id.imageView3)

        // Function to update the sum
        fun updateSum(checkBox: CheckBox, value: Int) {
            if (checkBox.isChecked) {
                sum += value
            } else {
                sum -= value
            }
            sumTextView.text = "£$sum"
        }

        // Function to clear all data
        fun clearData() {
            // Reset checkbox states
            checkBox1.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
            checkBox4.isChecked = false
            checkBox5.isChecked = false
            checkBox6.isChecked = false

            // Hide ImageViews
            imageView1.visibility = View.GONE
            imageView2.visibility = View.GONE
            imageView3.visibility = View.GONE
            imageView4.visibility = View.GONE
            imageView5.visibility = View.GONE
            imageView6.visibility = View.GONE

            // Reset sum
            sum = 6
            sumTextView.text = "£$sum"
        }

        // Toast for Order button
        val orderButton = findViewById<Button>(R.id.button)
        orderButton.setOnClickListener {
            val toast = Toast.makeText(this, "Your order is taken. You need to pay £$sum. Thank you!", Toast.LENGTH_SHORT)
            toast.show()
        }

        // Toast for Clear button
        val clearButton = findViewById<Button>(R.id.button2)
        clearButton.setOnClickListener {
            val toast = Toast.makeText(this, "Your selection is cleared. Thank you!", Toast.LENGTH_SHORT)
            toast.show()
            clearData()
        }

        // Set up checkboxes with their corresponding image views
        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            imageView1.visibility = if (isChecked) View.VISIBLE else View.GONE
            updateSum(checkBox1, 1)
        }

        checkBox2.setOnCheckedChangeListener { _, isChecked ->
            imageView2.visibility = if (isChecked) View.VISIBLE else View.GONE
            updateSum(checkBox2, 1)
        }

        checkBox3.setOnCheckedChangeListener { _, isChecked ->
            imageView3.visibility = if (isChecked) View.VISIBLE else View.GONE
            updateSum(checkBox3, 1)
        }

        checkBox4.setOnCheckedChangeListener { _, isChecked ->
            imageView4.visibility = if (isChecked) View.VISIBLE else View.GONE
            updateSum(checkBox4, 2)
        }

        checkBox5.setOnCheckedChangeListener { _, isChecked ->
            imageView5.visibility = if (isChecked) View.VISIBLE else View.GONE
            updateSum(checkBox5, 3)
        }

        checkBox6.setOnCheckedChangeListener { _, isChecked ->
            imageView6.visibility = if (isChecked) View.VISIBLE else View.GONE
            updateSum(checkBox6, 2)
        }

        // Apply window insets listener for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
