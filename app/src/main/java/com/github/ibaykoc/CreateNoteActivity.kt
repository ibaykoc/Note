/*
 *  Created by Mochammad Iqbal on 3/27/19 7:04 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/27/19 6:49 PM
 */

package com.github.ibaykoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_note.*

class CreateNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)
        save_Btn.setOnClickListener { finish() }
    }
}
