package studio.cn2b2t.core.listeners.events

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.event.Listener
import studio.cn2b2t.core.utils.flagWithEvent
import kotlin.math.abs

object NewPacketFlyCheck : Listener {
    private var tp = 150

    init {
                // protect
    }

    fun onPacket(event: PacketEvent) {
                // protect
    }
}
