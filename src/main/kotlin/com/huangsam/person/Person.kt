package com.huangsam.person

abstract class Person(protected val firstName: String) : CanRun, CanWalk, CanEat, CanSleep {
    override fun run() = println("${this.firstName} is running")

    override fun walk() = println("${this.firstName} is walking")

    override fun eat() = println("${this.firstName} is eating")

    override fun sleep() = println("${this.firstName} is sleeping")
}
