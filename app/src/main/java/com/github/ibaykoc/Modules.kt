/*
 *  Created by Mochammad Iqbal on 3/30/19 2:37 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 2:37 PM
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

    single {
        //        if (BuildConfig.DEBUG)
//            Room.inMemoryDatabaseBuilder(get(), NoteLocalDatabase::class.java).build()
//        else
            Room.databaseBuilder(get(), NoteLocalDatabase::class.java, "NoteLocalDatabase").build()
    }
}

val noteRepositoryModule = module {
    single { NoteRepository(get()) }
}

val homeModule = module {
    viewModel {
        HomeViewModel(get())
    }
}

val createNoteModule = module {
    viewModel { (noteUID: Int) ->
        CreateNoteViewModel(noteUID, get())
    }
}