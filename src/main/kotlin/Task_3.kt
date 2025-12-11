package org.example

import com.sun.tools.javac.Main
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger(Main::class.java)

fun main() {

    val list = listOf<Any?>("String", 5.11, null, 228, 'f', Pair("one", 2), 322, "Stroka", 25923L, 15)
    val findAllInt = list.findAllInt()
    findAllInt.forEach(::println)
}

fun List<Any?>.findAllInt() : List<Int> {
    return filterIsInstance<Int>().also { it.forEach { logger.info("В спсиок добавлен: $it") } }
}



