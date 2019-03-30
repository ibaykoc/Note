/*
 *  Created by Mochammad Iqbal on 3/30/19 7:56 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 5:30 AM
 */

package com.github.ibaykoc

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */
class NoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NoteApplication)
            modules(database, noteRepositoryModule, homeModule, createNoteModule)
        }
    }
}