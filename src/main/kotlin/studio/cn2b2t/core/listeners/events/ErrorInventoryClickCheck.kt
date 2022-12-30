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
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.instance, {
            try {
                packetCount.clear()
            } catch (ignored: Exception) {
            }
        }, 1000L, 1000L)
        Main.instance.protocolManager!!.addPacketListener(this)
    }

    override fun onPacketReceiving(event: PacketEvent) {
        if (!Main.instance.config.getBoolean("WindowClickCheck.check")) return
        val packet = WrapperPlayClientWindowClick(event.packet)
        val handle = (event.player as CraftPlayer).handle
        if (handle.activeContainer.windowId == packet.windowId) {
            if (event.player.openInventory != null) {
                if (packet.slot > handle.activeContainer.slots.size) event.isCancelled = true
            }
        } else {
            if (packet.slot > event.player.inventory.maxStackSize) event.isCancelled = true
        }
        try {
            increaseCountPos(event.player)
            if (packetCount[event.player]!! >= Main.instance.config.getInt("WindowClickCheck.count")) {
                event.isCancelled = true
            }
        } catch (ignored: Exception) {
        }
    }

    @EventHandler
    fun onLog(event: PlayerQuitEvent) {
        try {
            packetCount.remove(event.player)
        } catch (ignored: Exception) {
        }
    }

    private fun increaseCountPos(player: Player?) {
        if (packetCount.containsKey(player)) {
            var packetCounting = packetCount[player]!!
            packetCounting++
            packetCount[player!!] = packetCounting
        } else {
            packetCount[player!!] = 1
        }
    }
}