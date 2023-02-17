package studio.cn2b2t.core.command

import studio.cn2b2t.core.Main
import org.bukkit.command.CommandSender

abstract class BaseCommand {
    val cmdName: String
    val cmdAliases: Array<String>
    val cmdPerm: String
    val onlyClient: Boolean
    val onlyAdmin: Boolean

    abstract fun execute(sender: CommandSender, args: Array<out String>,main: studio.cn2b2t.core.Main)

    init {
        cmdName = getAnnotation().name
        cmdAliases = getAnnotation().aliases
        cmdPerm = getAnnotation().permission
        onlyClient = getAnnotation().playerOnly
        onlyAdmin = getAnnotation().opOnly
    }

    private fun getAnnotation(): CommandInfo {
        eprecated
    }
}
