package org.example

fun main() {

    val html = html {
        table {
            tr {
                "color" to "blue"
                td {
                    +"cell1"
                }
                td {
                    +"cell1"
                }
            }
        }
    }
    println(html)
}

fun html(init: Html.() -> Unit) = Html().apply(init)

class Html {
    private val children = mutableListOf<Element>()

    fun table(init: Table.() -> Unit) {
        children.add(Table().apply(init))
    }

    override fun toString(): String {
        return "<html>\n${children.joinToString("\n")}\n</html>"
    }
}

abstract class Element {
    val children = mutableListOf<Element>()
    val attributes = mutableMapOf<String, String>()

    abstract val tag: String

    override fun toString(): String {
        val attrs = if (attributes.isEmpty()) ""
        else " " + attributes.entries.joinToString(" ") { "${it.key}='${it.value}'" }
        val content = children.joinToString("\n") { it.toString() }
        return if (content.isBlank()) "<$tag$attrs/>" else "<$tag$attrs>$content</$tag>"    }
}

class Table : Element() {
    override val tag: String = "table"
    fun tr(init: Tr.() -> Unit) {
        children.add(Tr().apply(init))
    }
}

class Tr : Element() {
    override val tag = "tr"
    operator fun Pair<String, String>.unaryPlus() {
        attributes[this.first] = this.second
    }

    fun td(init: Td.() -> Unit) {
        children.add(Td().apply(init))
    }
}

class Td : Element() {
    override val tag = "td"
    operator fun String.unaryPlus() {
        children.add(Text(this))
    }
}

class Text(val text: String) : Element() {
    override val tag = ""
    override fun toString(): String = text
}