/*
 *  Created by Mochammad Iqbal on 3/28/19 8:23 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/28/19 8:23 AM
 */

package com.github.ibaykoc

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class CreateNoteFragment : Fragment() {

    private lateinit var viewModel: CreateNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_note_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateNoteViewModel::class.java)
    }

}
