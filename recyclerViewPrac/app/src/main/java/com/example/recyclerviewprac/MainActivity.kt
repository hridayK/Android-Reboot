package com.example.recyclerviewprac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var nameFiller: MutableList<String>
    private lateinit var descFiller: MutableList<String>
    private lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameFiller = resources.getStringArray(R.array.names).toMutableList()
        descFiller = resources.getStringArray(R.array.description).toMutableList()
        items = nameFiller.zip(descFiller, { a, b -> Item(a, b) }).toMutableList()

        val trialRecyclerView:RecyclerView = findViewById(R.id.recyclerView)

        trialRecyclerView.adapter = ItemAdapter(items)
        trialRecyclerView.layoutManager = LinearLayoutManager(this)
        trialRecyclerView.setHasFixedSize(true)

    }
}