package com.huangsam.hello

import org.slf4j.LoggerFactory

private const val HELLO_HELLO = "Hello hello"

class Hello {
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun say() {
        logger.info(HELLO_HELLO)
    }

    fun yell() {
        logger.warn(HELLO_HELLO.uppercase())
    }

    fun whisper() {
        logger.debug(HELLO_HELLO.lowercase())
    }

    fun address(name: String) {
        logger.info("$HELLO_HELLO $name")
    }
}
