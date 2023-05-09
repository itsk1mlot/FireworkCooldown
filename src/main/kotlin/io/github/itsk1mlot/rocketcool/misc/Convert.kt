package io.github.itsk1mlot.rocketcool.misc

import io.github.itsk1mlot.rocketcool.Main

object Convert {
    fun toTick(seconds: Int): Int {
        return seconds * 20
    }

    fun toSeconds(tick: Int): Int {
        return tick / 20
    }
}