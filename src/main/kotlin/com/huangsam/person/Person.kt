package com.huangsam.person

import org.slf4j.Logger
import org.slf4j.LoggerFactory

private const val AGE_TO_VOTE = 18

abstract class Person(val name: String, private val age: Int) : CanMove, CanLive {
    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun walk() = logger.warn("${this.name} is walking")

    override fun run() = logger.error("${this.name} is running")

    override fun eat() = logger.info("${this.name} is eating")

    override fun sleep() = logger.debug("${this.name} is sleeping")

    fun isReadyToVote(): Boolean = age >= AGE_TO_VOTE
}
