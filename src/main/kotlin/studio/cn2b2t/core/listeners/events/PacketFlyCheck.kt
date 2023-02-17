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
                // protect
                // protect
    }

    fun onPacket(event: PacketEvent) {
        // protect
    }
}
