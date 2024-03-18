package com.huangsam.registry

class KeyRegistry {
    private var mapping: MutableMap<String, String> = mutableMapOf()

    fun getValue(key: String): String? = mapping[key]

    fun setValue(
        key: String,
        value: String,
    ) {
        mapping[key] = value
    }

    fun clearValue(key: String) {
        mapping.remove(key)
    }

    fun clearValues() {
        mapping.clear()
    }

    /**
     * Singleton pattern
     * https://www.baeldung.com/kotlin/singleton-classes
     */
    companion object {
        @Volatile
        private var instance: KeyRegistry? = null

        fun getInstance() = instance ?: synchronized(this) { KeyRegistry().also { instance = it } }
    }
}
