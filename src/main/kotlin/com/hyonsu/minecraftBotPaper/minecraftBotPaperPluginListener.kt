package com.hyonsu.minecraftBotPaper

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.TextComponent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerAdvancementDoneEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class minecraftBotPaperPluginListener : Listener {
    @EventHandler
    fun PlayerJoin(e: PlayerJoinEvent) {
        playerJoin(e.player)
    }

    @EventHandler
    fun PlayerLeft(e: PlayerQuitEvent) {
        playerLeft(e.player)
    }

    @EventHandler
    fun PlayerChat(e: AsyncChatEvent) {
        val message = e.message()
        if(message is TextComponent) {
            val result = sendChat(e.player, message.content())
            if(result == "ok") e.isCancelled = true
        }
    }

    @EventHandler
    fun PlayerAchievement(e: PlayerAdvancementDoneEvent) {
        playerAchievement(e.player, e.advancement)
    }
}