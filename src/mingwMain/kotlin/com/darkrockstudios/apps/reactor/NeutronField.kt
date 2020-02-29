package com.darkrockstudios.apps.reactor

import com.darkrockstudios.apps.reactor.math.Vector2
import kotlin.random.Random
import kotlin.time.ExperimentalTime

class NeutronField {
    private val neutrons = arrayListOf<Array<Vector2>>()
    private val toRemove = arrayListOf<Int>()

    init {
        val capacity = 1_000_000
        neutrons.ensureCapacity(capacity)
        toRemove.ensureCapacity(capacity / 2)
    }

    fun add_neutron(position: Vector2, velocity: Vector2) {
        val neutron = arrayOf(position, velocity)
        neutrons.add(neutron)
    }

    @UseExperimental(ExperimentalTime::class)
    fun _physics_process(delta: Float) {

        val n = neutrons.size
        for (ii in 0 until n) {
            val neutron = neutrons[ii]
            val vel = neutron[1]

            neutron[0] += vel * delta

            if (Random.nextDouble(100.0) > 99.999)
                toRemove.add(ii)
        }

        // Remove neutrons in reverse
        toRemove.sortDescending()
        for( index in toRemove ) {
            neutrons.removeAt(index)
        }
        toRemove.clear()
        print(neutrons.size)
    }
}