/*
 *  Created by Mochammad Iqbal on 3/28/19 9:50 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/28/19 9:50 AM
 */

package com.github.ibaykoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.ibaykoc.databinding.CreateNoteFragmentBinding


class CreateNoteFragment : Fragment() {

    private lateinit var viewModel: CreateNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflate<CreateNoteFragmentBinding>(inflater, R.layout.create_note_fragment, container, false)
        binding.note = Note("Title Test", "Note Test")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateNoteViewModel::class.java)
    }

}
