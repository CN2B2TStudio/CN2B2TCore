package studio.cn2b2t.core.listeners

import org.bukkit.event.Listener
import studio.cn2b2t.core.Main
import studio.cn2b2t.core.listeners.events.*

class EventManager(main: Main) {
    private val listeners = ArrayList<Listener>()

    private var main: Main

    init {
        this.main = main
        initListener()
    }

    private fun initListener() {
        registerListener(ChatCoolDown)
        registerListener(CrystalSpeedLimit)
        registerListener(AntiShulkerBoxCrasher)
        registerListener(PacketFlyCheck)
        registerListener(NewPacketFlyCheck)
        registerListener(ErrorInventoryClickCheck)
    }

    private fun registerListener(listener: Listener) {
        if (!this.listeners.contains(listener)) {
            listeners.add(listener)
            main.server.pluginManager.registerEvents(listener, main)

        }
    }
}