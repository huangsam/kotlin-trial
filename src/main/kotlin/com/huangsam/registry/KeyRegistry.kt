package com.huangsam.registry

object KeyRegistry {
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
        mapping = HashMap()
    }
}
