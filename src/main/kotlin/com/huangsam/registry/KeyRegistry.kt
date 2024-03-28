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

    // https://www.baeldung.com/kotlin/singleton-classes
    companion object Singleton {
        @Volatile
        private var instance: KeyRegistry? = null

        fun getInstance() = instance ?: KeyRegistry().also { reg -> instance = reg }
    }
}
