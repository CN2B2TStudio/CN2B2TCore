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
        if (!runnable.contains(task)){
            runnable.add(task)
            if (task.isAsynchronously){
                Bukkit.getScheduler().runTaskTimerAsynchronously(main,task,task.delay,task.pri)
            }else{
                Bukkit.getScheduler().runTaskTimer(main,task,task.delay,task.pri)
            }
        }
    }

}