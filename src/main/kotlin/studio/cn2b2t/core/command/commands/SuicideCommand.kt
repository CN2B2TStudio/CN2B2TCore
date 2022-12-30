package studio.cn2b2t.core.command.commands

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import studio.cn2b2t.core.command.BaseCommand
import studio.cn2b2t.core.command.CommandInfo
import studio.cn2b2t.core.utils.sendWarningMessage

@CommandInfo(
    name = "kill",
    aliases = ["suicide", "kys", "514"],
    permission = "studio.2b2t.commands.kill",
    playerOnly = true
)
object SuicideCommand : BaseCommand() {
    override fun execute(sender: CommandSender, args: Array<out String>, main: studio.cn2b2t.core.Main) {
        if (sender.isOp) {
            if (args.isNotEmpty()) {
                val playerExact = Bukkit.getPlayerExact(args[0])
                if (playerExact != null) {
                    playerExact.health = 0.0
                } else {
                    sender.sendWarningMessage("&c&lThe player: ${args[0]} is not online!")
                }
            } else {
                (sender as Player).health = 0.0
            }
        } else {
            (sender as Player).health = 0.0
        }
    }
}