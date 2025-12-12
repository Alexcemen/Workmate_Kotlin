package org.example

class Singleton private constructor(
    val name: String,
    val age: Int
) {
    companion object {
        private var instance: Singleton? = null

        @Synchronized
        operator fun invoke(name: String, age: Int): Singleton {
            if (instance == null) instance = Singleton(name = name, age = age)
            return instance!!
        }
    }
}

fun main() {
    val singleton = Singleton("Ivan", 32)
    println("${singleton.name} ${singleton.age}")
}