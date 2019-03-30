/*
 *  Created by Mochammad Iqbal on 3/30/19 2:37 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 2:37 PM
 */

package com.github.ibaykoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.ibaykoc.databinding.HomeFragmentBinding
import com.github.ibaykoc.databinding.NoteListItemBinding
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lifecycle.addObserver(viewModel)
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        noteList_RecyclerView.adapter = NoteListAdapter(viewModel) {
            val action = HomeFragmentDirections.actionHomeFragmentToCreateNoteFragment(it)
            findNavController().navigate(action)
        }.also { adapter ->
            viewModel.notes.observe(this, Observer { adapter.notifyDataSetChanged() })
        }
        noteList_RecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        createNote_FAB.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCreateNoteFragment(-1)
            findNavController().navigate(action)
        }
    }

    class NoteListAdapter(private val viewModel: HomeViewModel, private val onItemClick: (noteID: Int) -> Unit) :
        RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val noteListItemBinding: NoteListItemBinding =
                DataBindingUtil.inflate(inflater, R.layout.note_list_item, parent, false)
            return ViewHolder(noteListItemBinding)
        }

        override fun getItemCount() = viewModel.notes.value?.size ?: 1

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            viewModel.notes.value?.get(position)?.let { note ->
                holder.noteListItemBinding.apply {
                    this.note = note
                    root.setOnClickListener { onItemClick(note.uid) }
                    executePendingBindings()
                }
            }
        }

        class ViewHolder(val noteListItemBinding: NoteListItemBinding) :
            RecyclerView.ViewHolder(noteListItemBinding.root)
    }
}
