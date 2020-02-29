package com.darkrockstudios.apps.reactor

import com.darkrockstudios.apps.reactor.math.Vector2
import platform.posix.rand
import kotlin.random.Random
import kotlin.system.getTimeMillis
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


val clock = Clock()

@ExperimentalTime
fun main() {
    println("Create random neutrons")

    val neutronField = NeutronField()
    clock.tick()
    measure("Neutron Creation: Vector2") {
        for (ii in 0..20_000) {
            neutronField.add_neutron(randomVector(), randomVector())
        }
    }

    println("Begin sim")
    while (true) {
        clock.tick()
        measure("Tick") {
            neutronField._physics_process(clock.delta)
        }
    }
}

