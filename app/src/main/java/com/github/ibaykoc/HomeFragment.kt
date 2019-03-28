/*
 *  Created by Mochammad Iqbal on 3/28/19 3:53 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/28/19 3:53 AM
 */

package com.github.ibaykoc

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        createNote_FAB.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_createNoteFragment) }
    }

}
