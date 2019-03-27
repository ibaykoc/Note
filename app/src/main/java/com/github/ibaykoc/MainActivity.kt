/*
 *  Created by Mochammad Iqbal on 3/27/19 7:08 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/27/19 6:01 PM
 */

package com.github.ibaykoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNote_FAB.setOnClickListener {
            val i = Intent(this, CreateNoteActivity::class.java)
            startActivity(i)
        }
    }
}
