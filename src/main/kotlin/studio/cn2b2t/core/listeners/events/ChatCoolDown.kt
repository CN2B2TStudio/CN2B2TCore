package studio.cn2b2t.core.listeners.events

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import studio.cn2b2t.core.Main
import studio.cn2b2t.core.utils.Timer
import studio.cn2b2t.core.utils.sendNormalMessage


object ChatCoolDown : Listener {
    private var lastChatTime = HashMap<Player, Timer>()

    @EventHandler
    fun onChat(e: AsyncPlayerChatEvent) {
        val p = e.player
        if (Main.instance.config.getBoolean("ChatCoolDown.ChatLimit")) {
            if (!e.player.isOp && !e.isCancelled) {
                if (lastChatTime.containsKey(p)) {
                    if (!lastChatTime[p]!!.passedSec(studio.cn2b2t.core.Main.instance.config.getLong("ChatCoolDown.LimitTime"))) {
                        e.isCancelled = true
                        p.sendNormalMessage(studio.cn2b2t.core.Main.instance.config.getString("ChatCoolDown.NotifyMessage"))
                        lastChatTime[p]!!.reset()
                    }
                } else {
                    lastChatTime[p] = Timer()
                    lastChatTime[p]!!.reset()
                }
            }
        }
    }
}