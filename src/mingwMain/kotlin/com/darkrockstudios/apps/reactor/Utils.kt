package com.darkrockstudios.apps.reactor

import com.darkrockstudios.apps.reactor.math.Vector2
import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun randomVector() = Vector2(Random.nextFloat(), Random.nextFloat())
fun randomVectorArray() = arrayOf<Float>(Random.nextFloat(), Random.nextFloat())

@ExperimentalTime
inline fun measure(label: String, block: () -> Unit) {
    val time = measureTime(block)
    println("$label took $time")
}