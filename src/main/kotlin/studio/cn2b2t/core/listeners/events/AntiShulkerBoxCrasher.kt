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
        val dispenser = event.block
        if (
            ((dispenser.location.blockY == dispenser.world.maxHeight - 1 && (dispenser.state.data as Directional).facing == BlockFace.UP) ||
                    (dispenser.location.blockY == 0 && (dispenser.state.data as Directional).facing == BlockFace.DOWN)) && event.item.type.toString()
                .lowercase().contains("shulker_box")
        ) {
            event.isCancelled = true
            broadCastWarning("&c&lThe dispenser: X:${dispenser.location.blockX} Y:${dispenser.location.blockY} Z: ${dispenser.location.blockZ} try to crash server!!!")
        }
    }
}