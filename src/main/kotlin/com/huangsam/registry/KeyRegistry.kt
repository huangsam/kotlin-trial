package com.huangsam.registry

object KeyRegistry {
    private var mapping = HashMap<String, String>();

    fun getValue(key: String): String? {
        return mapping[key]
    }

    fun setValue(key: String, value: String) {
        mapping[key] = value
    }

    fun clearValues() {
        mapping = HashMap<String, String>()
    }
}
