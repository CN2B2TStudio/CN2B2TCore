package studio.cn2b2t.core.listeners.events

import com.comphenix.packetwrapper.WrapperPlayClientWindowClick
import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.Bukkit
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
import studio.cn2b2t.core.Main
import java.util.concurrent.ConcurrentHashMap


object ErrorInventoryClickCheck : Listener,
    PacketAdapter(Main.instance, ListenerPriority.HIGH, PacketType.Play.Client.WINDOW_CLICK) {
    var packetCount = ConcurrentHashMap<Player, Int>()

    init {
                // protect
    }

    override fun onPacketReceiving(event: PacketEvent) {
                // protect
    }

    @EventHandler
    fun onLog(event: PlayerQuitEvent) {
        // protect
    }

    private fun increaseCountPos(player: Player?) {
        // protect
    }
}
