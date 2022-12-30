package studio.cn2b2t.core.listeners.events

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.event.Listener
import studio.cn2b2t.core.Main
import kotlin.math.abs


object PacketFlyCheck : Listener {
    private var tp: Int = 150

    init {
        val protocolManager = ProtocolLibrary.getProtocolManager()
        protocolManager.addPacketListener(object :
            PacketAdapter(Main.instance, ListenerPriority.HIGH, PacketType.Play.Client.POSITION) {
            override fun onPacketReceiving(event: PacketEvent) {
                onPacket(event)
            }
        })
        protocolManager.addPacketListener(object :
            PacketAdapter(Main.instance, ListenerPriority.HIGH, PacketType.Play.Client.POSITION_LOOK) {
            override fun onPacketReceiving(event: PacketEvent) {
                onPacket(event)
            }
        })
    }

    fun onPacket(event: PacketEvent) {
        val player = event.player
        val packet = event.packet
        val x = packet.doubles.read(0)
        val y = packet.doubles.read(1)
        val z = packet.doubles.read(2)
        val yaw = packet.float.read(0)
        val pitch = packet.float.read(1)
        try {
            if (studio.cn2b2t.core.Main.instance.config.getBoolean("PacketFlyCheck.ClassicCheck") && event.player.gameMode != GameMode.CREATIVE && !event.player.isInsideVehicle && !event.player.isGliding) {
                if (abs(pitch) > 90) {
                    event.isCancelled = true
                    player.teleport(player.location)
                    return
                }
                if (y <= -8) {
                    if (player.inventory.itemInMainHand.type == Material.CHORUS_FRUIT || player.inventory.itemInOffHand.type == Material.CHORUS_FRUIT) {
                        return
                    }
                    event.isCancelled = true
                    player.teleport(player.location)
                    return
                }
                val previous: Location = player.location.clone()
                previous.y = 0.0
                val current = Location(previous.world, x, 0.0, z, yaw, pitch)
                val distanceHorizontal: Double = previous.distanceSquared(current)
                val distanceVertical = y - player.location.y
                val maxDistanceHorizontal = tp.toDouble()
                if (distanceHorizontal > maxDistanceHorizontal && !player.isGliding && !player.isInsideVehicle) {
                    event.isCancelled = true
                    player.teleport(player.location)
                    return
                }
                if ((distanceVertical < -150 || distanceVertical >= 300) && !player.isGliding && !player.isInsideVehicle) {
                    if (distanceVertical < -150) {
                        if (player.inventory.itemInMainHand.type == Material.CHORUS_FRUIT || player.inventory.itemInOffHand.type == Material.CHORUS_FRUIT) {
                            return
                        }
                    }
                    event.isCancelled = true
                    player.teleport(player.location)
                }
            }
        } catch (ignored: Exception) {
        }
    }
}