package studio.cn2b2t.core.runnable

import org.bukkit.Bukkit
import studio.cn2b2t.core.Main

class TaskManager(main: Main) {
    private val runnable = ArrayList<TaskRunnable>()

    private var main: Main

    init {
        this.main = main
    }

    private fun registerRunnable(task: TaskRunnable) {
        // Protected Code by DrRockyMC's CodeTool
    }

}
