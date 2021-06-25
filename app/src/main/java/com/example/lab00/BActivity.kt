package com.example.lab00

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class BActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val num0 = findViewById<Button>(R.id.num0)
        val num1 = findViewById<Button>(R.id.num1)
        val num2 = findViewById<Button>(R.id.num2)
        val num3 = findViewById<Button>(R.id.num3)
        val num4 = findViewById<Button>(R.id.num4)
        val num5 = findViewById<Button>(R.id.num5)
        val num6 = findViewById<Button>(R.id.num6)
        val num7 = findViewById<Button>(R.id.num7)
        val num8 = findViewById<Button>(R.id.num8)
        val num9 = findViewById<Button>(R.id.num9)
        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)
        val multiple = findViewById<Button>(R.id.multiple)
        val slush = findViewById<Button>(R.id.slush)
        val clear = findViewById<Button>(R.id.clear)
        val result = findViewById<Button>(R.id.result)
        var edit_result = findViewById<EditText>(R.id.edit_result)
        var listResult = mutableListOf<String>()
        var cal_result = 0.0

        num0.setOnClickListener {
            edit_result.setText(edit_result.getText().append("0"))
            listResult.add("0")
        }
        num1.setOnClickListener {
            edit_result.setText(edit_result.getText().append("1"))
            listResult.add("1")
        }
        num2.setOnClickListener {
            edit_result.setText(edit_result.getText().append("2"))
            listResult.add("2")
        }
        num3.setOnClickListener {
            edit_result.setText(edit_result.getText().append("3"))
            listResult.add("3")
        }
        num4.setOnClickListener {
            edit_result.setText(edit_result.getText().append("4"))
            listResult.add("4")
        }
        num5.setOnClickListener {
            edit_result.setText(edit_result.getText().append("5"))
            listResult.add("5")
        }
        num6.setOnClickListener {
            edit_result.setText(edit_result.getText().append("6"))
            listResult.add("6")
        }
        num7.setOnClickListener {
            edit_result.setText(edit_result.getText().append("7"))
            listResult.add("7")
        }
        num8.setOnClickListener {
            edit_result.setText(edit_result.getText().append("8"))
            listResult.add("8")
        }
        num9.setOnClickListener {
            edit_result.setText(edit_result.getText().append("9"))
            listResult.add("9")
        }
        plus.setOnClickListener {
            edit_result.setText(edit_result.getText().append("+"))
            listResult.add("+")
        }
        minus.setOnClickListener {
            edit_result.setText(edit_result.getText().append("-"))
            listResult.add("-")
        }
        multiple.setOnClickListener {
            edit_result.setText(edit_result.getText().append("X"))
            listResult.add("X")
        }
        slush.setOnClickListener {
            edit_result.setText(edit_result.getText().append("/"))
            listResult.add("/")
        }
        clear.setOnClickListener {
            edit_result.setText("")
            cal_result = 0.0
            while(listResult.size>0){
                listResult.removeAt(0)
            }
        }
        result.setOnClickListener {
            var value1 = 0.0
            var value2 = 0.0
            var op = ""

            while(listResult[0] != "+" && listResult[0] != "-" && listResult[0] != "X" && listResult[0] != "/"){
                if(value1 != 0.0){
                    value1 = (value1*10) + listResult[0].toDouble()
                    listResult.removeAt(0)
                }
                else{
                    value1 = listResult[0].toDouble()
                    listResult.removeAt(0)
                }
            }

            op = listResult[0]
            listResult.removeAt(0)

            while(listResult.size > 0){
                if(value2 != 0.0){
                    value2 = (value2*10) + listResult[0].toDouble()
                    listResult.removeAt(0)
                }
                else{
                    value2 = listResult[0].toDouble()
                    listResult.removeAt(0)
                }
            }

            when (op) {
                "+" -> cal_result = value1 + value2
                "-" -> cal_result = value1 - value2
                "X" -> cal_result = value1 * value2
                "/" -> cal_result = value1 / value2
            }

            edit_result.setText(cal_result.toString())
            listResult.add(cal_result.toString())
        }
    }
}