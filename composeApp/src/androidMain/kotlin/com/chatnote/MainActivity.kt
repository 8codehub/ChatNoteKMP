package com.chatnote

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plcoding.room_cmp.database.getAppDatabase

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = getAppDatabase(applicationContext).folderDao()


        setContent {
            App(dao)
        }
    }
}