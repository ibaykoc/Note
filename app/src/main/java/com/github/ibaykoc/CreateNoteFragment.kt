/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
 */

package com.github.ibaykoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.ibaykoc.databinding.CreateNoteFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class CreateNoteFragment : Fragment() {

    private val viewModel: CreateNoteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<CreateNoteFragmentBinding>(
            inflater,
            R.layout.create_note_fragment,
            container,
            false
        )
        binding.viewModel = viewModel
        return binding.root
    }

}
