package com.example.lab00

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.ArrayList

class AActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val listView = findViewById<ListView>(R.id.listview)
        val nameList = ArrayList<String>()
        val addbtn = findViewById<Button>(R.id.button_edit)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)
        val newName = findViewById<EditText>(R.id.et1)

        listView.adapter = adapter

        addbtn.setOnClickListener {
            newName.setText("")
            if (newName.getText().toString().length > 0){
                val inputStr = newName.getText().toString()
                adapter.add(inputStr)
                adapter.notifyDataSetChanged()
            }
        }
    }

}