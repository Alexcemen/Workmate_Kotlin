package org.example

fun main() {
    val list: List<Int?>? = listOf(228, null, 146, 322, null, 11, null, null, null)
    println(list.shakeSort())
}

fun List<Int?>?.shakeSort(): List<Int?> {
    if (this == null) return emptyList()

    val list = this.toMutableList()
    var left = 0
    var right = list.lastIndex
    var swapped: Boolean

    fun swap(firstIndex: Int, secondIndex: Int): Boolean {
        val first = list[firstIndex]
        val second = list[secondIndex] ?: return false
        return if (first == null || first > second) {
            list[firstIndex] = second
            list[secondIndex] = first
            true
        } else false
    }

    do {
        swapped = false

        for (i in left until right) {
            if (swap(i, i + 1)) swapped = true
        }
        right--

        for (i in right downTo left + 1) {
            if (swap(i - 1, i)) swapped = true
        }
        left++

    } while (swapped)

    return list
}