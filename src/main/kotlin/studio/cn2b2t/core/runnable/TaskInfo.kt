package studio.cn2b2t.core.runnable

annotation class TaskInfo(
    val asynchronously: Boolean = false,
    val delay: Long,
    val pri: Long
    )