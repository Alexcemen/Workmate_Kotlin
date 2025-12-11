package org.example


fun main() {
    val string = "Stroka"
    println(string.lastCharOrNull())
    println(string.reversedString())

    val list1 = listOf<Any?>()
    println(list1.gerPairFirstAndLastElementOrNull().toString())
    val list2 = listOf<Any?>(null, 1, 5.67, null)
    println(list2.gerPairFirstAndLastElementOrNull().toString())
    val list3 = listOf<Any?>("sdfsdf", null, 1, 5.67, null)
    println(list3.gerPairFirstAndLastElementOrNull().toString())
    val list4 = listOf<Any?>("sdfsdf", null, 1, 5.67, null, 3435L)
    println(list4.gerPairFirstAndLastElementOrNull().toString())

    val text1 = "text"
    val text2 = "texttxet"
    val text3 = ""
    val text4 = " "
    val text5 = null
    println(text1.isPalindromic)
    println(text2.isPalindromic)
    println(text3.isPalindromic)
    println(text4.isPalindromic)
    println(text5.isPalindromic)

    val stringBuilder = StringBuilder("stringBuilder")
    println(stringBuilder.lastChar)
    stringBuilder.lastChar = '!'
    println(stringBuilder.toString())
    val emptyStringBuilder = StringBuilder()
    emptyStringBuilder.lastChar = 'A'
    println(emptyStringBuilder.toString())
}

fun String.lastCharOrNull(): Char? = if (isEmpty()) null else this[lastIndex]

fun String.reversedString(): String {
    return (this as CharSequence).reversed().toString()
}

fun <T> List<T>.gerPairFirstAndLastElementOrNull(): Pair<T, T>? {
    if (isEmpty()) return null
    return first() to last()
}

val String?.isPalindromic: Boolean
    get() {
        return if (this == null || isBlank()) false
        else this == reversed()
    }

var StringBuilder.lastChar: Char
    get() = (if (isEmpty()) "" else this[lastIndex]) as Char
    set(value) {
        if (isEmpty()) this.append(value) else this.setCharAt(lastIndex, value)
    }
