/*
 *  Created by Mochammad Iqbal on 3/30/19 2:37 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 2:37 PM
 */

package com.github.ibaykoc

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.ibaykoc.databinding.CreateNoteFragmentBinding
import kotlinx.android.synthetic.main.create_note_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class CreateNoteFragment : Fragment() {

    private val navigationArgs: CreateNoteFragmentArgs by navArgs()
    private val viewModel: CreateNoteViewModel by viewModel {
        parametersOf(navigationArgs.noteID)
    }

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
        viewModel.note.observe(this, Observer { binding.invalidateAll() })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_Btn.setOnClickListener {
            viewModel.saveNote {
                activity?.getSystemService(Activity.INPUT_METHOD_SERVICE)?.let {
                    (it as InputMethodManager).hideSoftInputFromWindow(view.windowToken, 0)
                }
                this.findNavController().popBackStack()
            }
        }
    }

}
