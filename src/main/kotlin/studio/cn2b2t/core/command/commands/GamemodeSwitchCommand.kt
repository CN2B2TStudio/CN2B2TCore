package studio.cn2b2t.core.command.commands

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import studio.cn2b2t.core.command.CommandInfo
import studio.cn2b2t.core.utils.sendNormalMessage
import studio.cn2b2t.core.utils.sendWarningMessage

@CommandInfo(name = "gamemode", aliases = ["gm"], playerOnly = true, opOnly = true)
object GamemodeSwitchCommand : studio.cn2b2t.core.command.BaseCommand() {
    override fun execute(sender: CommandSender, args: Array<out String>, main: studio.cn2b2t.core.Main) {
        if (args.isEmpty()) {
            sender.sendWarningMessage("&c&lWrong command, usage:/gamemode <mode> [player]")
            return
        }
        when (args[0].lowercase()) {
            "survival", "sur", "s", "0" -> {
                if (args.size >= 2) {
                    val playerExact = Bukkit.getPlayerExact(args[1])
                    if (playerExact == null) {
                        sender.sendWarningMessage("&cThe player: ${args[1]} is not online!")
                        return
                    }
                    playerExact.gameMode = GameMode.SURVIVAL
                    sender.sendNormalMessage("&aChanged player: ${args[1]}'s gamemode to survival!")
                    return
                }
                (sender as Player).gameMode = GameMode.SURVIVAL
                sender.sendNormalMessage("&aChanged your gamemode to survival!")
            }

            "creative", "create", "c", "1", "cre" -> {
                if (args.size >= 2) {
                    val playerExact = Bukkit.getPlayerExact(args[1])
                    if (playerExact == null) {
                        sender.sendWarningMessage("&cThe player: ${args[1]} is not online!")
                        return
                    }
                    playerExact.gameMode = GameMode.CREATIVE
                    sender.sendNormalMessage("&aChanged player: ${args[1]}'s gamemode to creative!")
                    return
                }
                (sender as Player).gameMode = GameMode.CREATIVE
                sender.sendNormalMessage("&aChanged your gamemode to creative!")
            }

            "spectator", "spec", "3", "spector" -> {
                if (args.size >= 2) {
                    val playerExact = Bukkit.getPlayerExact(args[1])
                    if (playerExact == null) {
                        sender.sendWarningMessage("&cThe player: ${args[1]} is not online!")
                        return
                    }
                    playerExact.gameMode = GameMode.SPECTATOR
                    sender.sendNormalMessage("&aChanged player: ${args[1]}'s gamemode to spectator!")
                    return
                }
                (sender as Player).gameMode = GameMode.SPECTATOR
                sender.sendNormalMessage("&aChanged your gamemode to spectator!")
            }

            "adventure", "advent", "adv", "2", "a" -> {
                if (args.size >= 2) {
                    val playerExact = Bukkit.getPlayerExact(args[1])
                    if (playerExact == null) {
                        sender.sendWarningMessage("&cThe player: ${args[1]} is not online!")
                        return
                    }
                    playerExact.gameMode = GameMode.ADVENTURE
                    sender.sendNormalMessage("&aChanged player: ${args[1]}'s gamemode to adventure!")
                    return
                }
                (sender as Player).gameMode = GameMode.ADVENTURE
                sender.sendNormalMessage("&aChanged your gamemode to adventure!")
            }

            else -> {
                sender.sendWarningMessage("&cIllegal Argument: ${args[0]}, that is not a gamemode!")
            }
        }
    }
}