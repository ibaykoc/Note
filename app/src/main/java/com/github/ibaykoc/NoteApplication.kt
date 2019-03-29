/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/28/19 5:47 PM
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
            modules(noteRepositoryModule, createNoteModule)
        }
    }
}