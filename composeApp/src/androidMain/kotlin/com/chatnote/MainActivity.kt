package com.chatnote

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.room_cmp.database.getPeopleDatabase

class MainActivity : ComponentActivity() {
    val dao = getPeopleDatabase(applicationContext).peopleDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            App(dao)
        }
    }
}