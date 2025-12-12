package org.example

fun main() {
    val barbwire: Barbwire = Hedgehog() + Snake()
    println(barbwire)
}

class Hedgehog{
    override fun toString() = "Hedgehog"
    operator fun plus(snake: Snake): Barbwire {
        return Barbwire()
    }
}

class Snake {
    override fun toString() = "Snake"
}

class Barbwire {
    override fun toString() = "Barbwire"
}