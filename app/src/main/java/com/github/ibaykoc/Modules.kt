/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
 */

package com.github.ibaykoc

import androidx.room.Room
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */

val database = module {
    single { Room.databaseBuilder(get(), NoteLocalDatabase::class.java, "NoteLocalDatabase").build() }
}

val noteRepositoryModule = module {
    single { NoteRepository(get()) }
}

val createNoteModule = module {
    viewModel {
        CreateNoteViewModel(get())
    }
}