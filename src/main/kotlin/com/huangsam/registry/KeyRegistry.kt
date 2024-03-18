package com.huangsam.registry

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

class KeyRegistry {
    private var mapping: ConcurrentMap<String, String> = ConcurrentHashMap()

    @Synchronized
    fun getValue(key: String): String? = mapping[key]

    @Synchronized
    fun setValue(
        key: String,
        value: String,
    ) {
        mapping[key] = value
    }

    @Synchronized
    fun clearValue(key: String) {
        mapping.remove(key)
    }

    @Synchronized
    fun clearValues() {
        mapping.clear()
    }

    // https://www.baeldung.com/kotlin/singleton-classes
    companion object Singleton {
        @Volatile
        private var instance: KeyRegistry? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: KeyRegistry().also { instance = it }
        }
    }
}
