package com.codigototal.notesformy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.codigototal.notesformy.addtask.ui.TaskScreen
import com.codigototal.notesformy.addtask.ui.TaskViewModel
import com.codigototal.notesformy.ui.theme.NotesForMyTheme
import dagger.hilt.android.AndroidEntryPoint

//! Single Activity
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val taskViewModel:TaskViewModel by viewModels() //Necesario Inicial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesForMyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TaskScreen(taskViewModel)
                    TaskScreen(taskViewModel)
                }
            }
        }
    }
}