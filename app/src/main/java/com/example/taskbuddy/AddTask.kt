package com.example.taskbuddy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskbuddy.databinding.ActivityAddTaskBinding
import com.example.taskbuddy.databinding.ActivityMainBinding

class AddTask : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db:TaskDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabaseHelper(this)

        binding.SaveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val task = Task(0,title,content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Saved",Toast.LENGTH_SHORT).show()

        }
    }
}