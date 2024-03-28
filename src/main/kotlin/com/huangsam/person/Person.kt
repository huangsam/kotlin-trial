package com.huangsam.person

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Person(val firstName: String) : CanMove, CanLive {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun walk() = logger.warn("${this.firstName} is walking")

    override fun run() = logger.error("${this.firstName} is running")

    override fun eat() = logger.info("${this.firstName} is eating")

    override fun sleep() = logger.debug("${this.firstName} is sleeping")
}
