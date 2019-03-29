/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:08 PM
 */

package com.github.ibaykoc

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    var title: String,
    var note: String
) : BaseObservable()