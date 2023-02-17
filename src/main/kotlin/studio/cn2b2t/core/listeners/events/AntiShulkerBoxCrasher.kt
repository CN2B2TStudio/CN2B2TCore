package studio.cn2b2t.core.listeners.events

import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockDispenseEvent
import org.bukkit.material.Directional
import studio.cn2b2t.core.utils.broadCastWarning

object AntiShulkerBoxCrasher : Listener {

    @EventHandler
    fun onDispense(event: BlockDispenseEvent) {
        // protect
    }
}
