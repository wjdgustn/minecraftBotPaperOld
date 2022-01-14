package com.hyonsu.globalPlugin

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class GlobalPluginListener : Listener {
    @EventHandler
    fun PlayerJoin(e: PlayerJoinEvent) {
        val p = e.player
        p.sendMessage("hi player")
    }
}