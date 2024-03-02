package com.huangsam.hello

class Hello {
    private val helloString = "Hello world"

    private fun hello(): String {
        return helloString
    }

    fun say() {
        println(hello())
    }

    fun yell() {
        println(hello().uppercase())
    }

    fun whisper() {
        println(hello().lowercase())
    }

    fun address(name: String) {
        println("${hello()} $name")
    }
}
