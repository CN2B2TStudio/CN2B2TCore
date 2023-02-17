package studio.cn2b2t.core.utils

import studio.cn2b2t.core.Main
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import java.util.logging.Logger

fun colorString(string: String): String {
    return ChatColor.translateAlternateColorCodes('&', string)
}

fun CommandSender.sendNormalMessage(msg: String) {
    this.sendMessage(colorString(studio.cn2b2t.core.Main.prefix + msg))
}

fun CommandSender.sendWarningMessage(msg: String) {
    this.sendMessage(colorString(studio.cn2b2t.core.Main.prefix + "&8[&e&lWarning&8]&r" + msg))
}

fun CommandSender.sendErrorMessage(msg: String) {
    this.sendMessage(colorString(studio.cn2b2t.core.Main.prefix + "&8[&c&lError&8]&r" + msg))
}

fun broadCastWarning(msg: String) {
    // protect
}

fun Logger.logNormalMessage(msg: String) {
    // protect
}

fun Logger.logWarningMessage(msg: String) {
    // protect
}

fun Logger.logErrorMessage(msg: String) {
    // protect
}
