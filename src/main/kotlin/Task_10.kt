package org.example

fun main() {
    println(getFibonacciNumbers(15).toList())
}

fun getFibonacciNumbers(n: Int): Sequence<Int> {
    return generateSequence(Pair(0, 1)) { (n1, n2) -> n2 to n1 + n2 }
        .map { it.first }
        .take(n)
}