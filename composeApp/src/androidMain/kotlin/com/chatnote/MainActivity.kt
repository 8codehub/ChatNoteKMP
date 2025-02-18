package com.chatnote

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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