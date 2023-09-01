package com.example.android_protodatastore_example

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.test.Pref

internal val Context.prefStore: DataStore<Pref> by dataStore(
    fileName = "pref.pb",
    serializer = PrefSerializer
)
