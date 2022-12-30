package studio.cn2b2t.core.utils

class Timer {
    private var lastTimer: Long = System.currentTimeMillis()

    fun passedMs(ms: Long): Boolean {
        return System.currentTimeMillis() - this.lastTimer >= ms
    }

    fun passedSec(sec: Long): Boolean {
        return passedMs(sec * 1000)
    }

    fun passedMin(min: Int): Boolean {
        return passedSec((min * 60).toLong())
    }

    fun reset() {
        lastTimer = System.currentTimeMillis()
    }
}