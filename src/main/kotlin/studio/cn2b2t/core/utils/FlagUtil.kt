package studio.cn2b2t.core.utils

import studio.cn2b2t.core.Main.Companion.sendToMainThread
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player

fun flagWithEvent(player: CraftPlayer, location: Location?, event: PacketEvent, cancel: Boolean) {
    // protect
}

fun flagNoEvent(player: CraftPlayer, location: Location?) {
    // protect
}

fun flagNoEvent(player: Player, location: Location?) {
    // protect
}

fun flagNoEvent(player: CraftPlayer, x: Double, y: Double, z: Double) {
    // protect
}

fun flagNoEvent(player: CraftPlayer, x: Double, y: Double, z: Double, yaw: Float, pitch: Float) {
    // protect
}
