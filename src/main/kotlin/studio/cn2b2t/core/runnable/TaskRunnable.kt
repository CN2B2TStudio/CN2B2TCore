package studio.cn2b2t.core.runnable

import studio.cn2b2t.core.Main

abstract class TaskRunnable: Runnable{

    var isAsynchronously: Boolean

    var delay: Long

    var pri: Long

    init {
        isAsynchronously = getAnnotation().asynchronously
        delay = getAnnotation().delay
        pri = getAnnotation().pri
    }

    override fun run() {}

    private fun getAnnotation(): TaskInfo {
        // Protected Code by DrRockyMC's CodeTool
    }
}
