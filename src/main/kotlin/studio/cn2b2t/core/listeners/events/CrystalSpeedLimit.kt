package studio.cn2b2t.core.listeners.events

import org.bukkit.entity.EnderCrystal
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerQuitEvent
import studio.cn2b2t.core.utils.Timer
import kotlin.collections.HashMap

object CrystalSpeedLimit : Listener {

    private val breakDelay: HashMap<Player, Timer> = HashMap()

    @EventHandler
    fun onHittingCrystal(event: EntityDamageByEntityEvent) {
        if (!studio.cn2b2t.core.Main.instance.config.getBoolean("CrystalSpeedLimit.limit") || event.damager !is Player || event.entity !is EnderCrystal || event.isCancelled) return
        val player = event.damager as Player
        if (breakDelay.containsKey(player)) {
            if (!breakDelay[player]!!.passedMs(studio.cn2b2t.core.Main.instance.config.getLong("CrystalSpeedLimit.BreakDelay"))) {
                event.isCancelled = true
            } else {
                breakDelay[player]!!.reset()
            }
        } else {
            breakDelay[player] = null
        }
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent){
        if (breakDelay.containsKey(event.player)) breakDelay.remove(event.player)
    }
}
