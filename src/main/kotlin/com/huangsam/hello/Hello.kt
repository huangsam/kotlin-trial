package com.huangsam.hello

import org.slf4j.LoggerFactory

class Hello {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val helloString = "Hello world"

    fun say() {
        logger.info(helloString)
    }

    fun yell() {
        logger.warn(helloString.uppercase())
    }

    fun whisper() {
        logger.debug(helloString.lowercase())
    }

    fun address(name: String) {
        logger.info("$helloString $name")
    }
}
