package com.huangsam.registry

class KeyRegistry {
    private var mapping: MutableMap<String, String> = mutableMapOf()

    fun getValue(key: String): String? {
        return mapping[key]
    }

    fun setValue(
        key: String,
        value: String,
    ) {
        mapping[key] = value
    }

    fun clearValues() {
        mapping = mutableMapOf()
    }

    companion object {
        @Volatile
        private var instance: KeyRegistry? = null

        fun getInstance() = instance ?: synchronized(this) { KeyRegistry().also { instance = it } }
    }
}
