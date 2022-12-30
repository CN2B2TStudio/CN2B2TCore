package studio.cn2b2t.core.utils

import studio.cn2b2t.core.Main.Companion.sendToMainThread
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player

fun flagWithEvent(player: CraftPlayer, location: Location?, event: PacketEvent, cancel: Boolean) {
    event.isCancelled = cancel
    sendToMainThread { val bl = player.teleport(location) }
}

fun flagNoEvent(player: CraftPlayer, location: Location?) {
    sendToMainThread { val bl = player.teleport(location) }
}

fun flagNoEvent(player: Player, location: Location?) {
    sendToMainThread { val bl = player.teleport(location) }
}

fun flagNoEvent(player: CraftPlayer, x: Double, y: Double, z: Double) {
    sendToMainThread { val bl = player.teleport(Location(player.world, x, y, z)) }
}

fun flagNoEvent(player: CraftPlayer, x: Double, y: Double, z: Double, yaw: Float, pitch: Float) {
    sendToMainThread { val bl = player.teleport(Location(player.world, x, y, z, yaw, pitch)) }
}