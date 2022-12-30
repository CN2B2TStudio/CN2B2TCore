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
        if (javaClass.isAnnotationPresent(TaskInfo::class.java)) {
            return javaClass.getAnnotation(TaskInfo::class.java)
        }
        throw IllegalStateException("No Annotation on class " + this.javaClass.canonicalName + "!")
    }
}