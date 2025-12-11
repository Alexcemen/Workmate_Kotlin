package org.example


fun main() {
    println(Color.GREEN.rgb())
    println(Color.YELLOW.rgb())
}

enum class Color(val r: Int, val g: Int, val b: Int) {

    GREEN(0, 255, 0),
    RED(255, 0, 0),
    MAGENTA(255, 0, 255),
    YELLOW(255, 255, 0),
    BLACK(0, 0, 0),
    BLUE(0, 0, 255);

    fun rgb(): String {
        return String.format("#%02X%02X%02X", r, g, b)
    }
}