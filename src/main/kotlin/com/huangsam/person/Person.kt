package com.huangsam.person

import java.io.PrintStream

abstract class Person(
    protected val firstName: String,
    printer: PrintStream = System.out,
) : CanRun, CanWalk, CanEat, CanSleep {
    protected val printer: PrintStream by lazy { printer }

    override fun run() = printer.println("${this.firstName} is running")

    override fun walk() = printer.println("${this.firstName} is walking")

    override fun eat() = printer.println("${this.firstName} is eating")

    override fun sleep() = printer.println("${this.firstName} is sleeping")
}
