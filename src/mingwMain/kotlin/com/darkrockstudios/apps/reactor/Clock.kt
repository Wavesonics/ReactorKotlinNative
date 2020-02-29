package com.darkrockstudios.apps.reactor

import kotlin.system.getTimeMillis

class Clock {
    private var lastTime: Long = 0L
    var delta: Float = 0.0f

    fun tick() {
        val curTime = getTimeMillis()
        delta = ((curTime - lastTime).toFloat() ) / 1000.0f
        lastTime = curTime
    }
}