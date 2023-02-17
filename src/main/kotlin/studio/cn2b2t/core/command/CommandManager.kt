package studio.cn2b2t.core.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import studio.cn2b2t.core.Main
import studio.cn2b2t.core.command.commands.*
import studio.cn2b2t.core.utils.colorString
import studio.cn2b2t.core.utils.logWarningMessage
import studio.cn2b2t.core.utils.sendWarningMessage
import kotlin.collections.ArrayList

class CommandManager(main: Main) : CommandExecutor {
    private val commands = ArrayList<BaseCommand>()

    private var main: Main

    init {
        this.main = main
    }

    override fun onCommand(
        sender: CommandSender, command: Command, label: String, arguments: Array<out String>
    ): Boolean {
        for (baseCommand in commands) {
            //protect
            baseCommand.execute(sender, arguments, main)
        }
        return true
    }

    init {
        registerCommand(SuicideCommand)
        registerCommand(GamemodeSwitchCommand)
        registerCommand(DuplicationCommand)
    }

    private fun isAliases(cmdName: String, args: Array<String>): Boolean {
        for (arg in args) {
            if (arg.lowercase() == cmdName.lowercase()) return true
        }
        return false
    }

    private fun registerCommand(cmd: BaseCommand) {
        try {
            if (!commands.contains(cmd)) {
                commands.add(cmd)
                main.server.getPluginCommand(cmd.cmdName).executor = this
            }
        } catch (e: Exception) {
            throw CommandNoRegisterException("&c&lThe command: ${colorString("&a&l${cmd.cmdName}&c&l")} not register in \'plugin.yml\'!!!")
        }
    }
}
