package studio.cn2b2t.core

import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.ProtocolManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import studio.cn2b2t.core.command.CommandManager
import studio.cn2b2t.core.listeners.EventManager
import studio.cn2b2t.core.runnable.TaskManager
import studio.cn2b2t.core.utils.colorString
import studio.cn2b2t.core.utils.logNormalMessage


class Main : JavaPlugin() {

    private var commandManager: CommandManager? = null
    private var eventManager: EventManager? = null
    private var taskManager: TaskManager? = null
    var protocolManager: ProtocolManager? = null

    companion object {
        var prefix: String? = null
        lateinit var instance: Main
        fun sendToMainThread(runnable: Runnable?) {
            Bukkit.getScheduler().runTask(instance, runnable)
        }
    }

    init {
        instance = this
    }

    @Throws(Exception::class)
    override fun onLoad() {
        saveDefaultConfig()
        prefix = colorString(config.getString("PluginPrefix"))
        protocolManager = ProtocolLibrary.getProtocolManager()
        logger.logNormalMessage("&a Hooked ProtocolLib Manager")
        println("[CN2B2TCore]Success!!!")
    }

    @Throws(Exception::class)
    override fun onEnable() {
        val timeStart = System.currentTimeMillis()
        commandManager = CommandManager(this)
        logger.logNormalMessage("&a initiation Command Manager")
        eventManager = EventManager(this)
        logger.logNormalMessage("&a initiation Event Manager")
        taskManager = TaskManager(this)
        logger.logNormalMessage("&a initiation Task Manager")
        logger.logNormalMessage("&bCN2B2TStudio  Ready to fight!")
        logger.logNormalMessage("&eCN2B2TStudio Loaded in ${System.currentTimeMillis() - timeStart}ms!")
    }
}
