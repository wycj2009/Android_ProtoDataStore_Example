package com.example.android_protodatastore_example

import androidx.datastore.core.Serializer
import com.example.test.Pref
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object PrefSerializer : Serializer<Pref> {

    override val defaultValue: Pref = Pref.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Pref {
        try {
            return Pref.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            throw e
        }
    }

    override suspend fun writeTo(t: Pref, output: OutputStream) {
        t.writeTo(output)
    }
}
