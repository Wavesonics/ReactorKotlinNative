package com.darkrockstudios.apps.reactor

import com.darkrockstudios.apps.reactor.math.Vector2

data class Rect(val topLeft: Vector2, val bottomRight: Vector2) {
    fun contains(pt: Vector2): Boolean {
        return pt.x > topLeft.x && pt.x < bottomRight.x &&
                pt.y > topLeft.y && pt.y < bottomRight.y;
    }
}