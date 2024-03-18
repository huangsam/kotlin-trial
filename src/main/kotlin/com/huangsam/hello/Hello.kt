package com.huangsam.hello

class Hello {
    private val helloString
        get() = "Hello world"

    fun say() {
        println(helloString)
    }

    fun yell() {
        println(helloString.uppercase())
    }

    fun whisper() {
        println(helloString.lowercase())
    }

    fun address(name: String) {
        println("$helloString $name")
    }
}
