package com.hyonsu.minecraftBotPaper

import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

class minecraftBotPaperPlugin : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(minecraftBotPaperPluginListener(), this)

        println("§aplugin enabled")

        kommand {
            command()
        }
    }
}