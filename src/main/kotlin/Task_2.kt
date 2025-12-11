package org.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.properties.ReadOnlyProperty
import org.slf4j.LoggerFactory
import kotlin.reflect.KProperty

fun main() {
    val logMaker by LogMaker()
    Thread.sleep(100_000L)
}

class LogMaker() : ReadOnlyProperty<Any?, String> {
    val logger = LoggerFactory.getLogger(LogMaker::class.java)

    private val startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

    private val scope = CoroutineScope(Dispatchers.Default)

    init {
        scope.launch {
            while (isActive) {
                logger.info("Start: $startTime")
                delay(3000L)
            }
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>) = startTime
}


