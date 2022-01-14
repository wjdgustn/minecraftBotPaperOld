package com.hyonsu.globalPlugin

import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

class GlobalPlugin : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(GlobalPluginListener(), this)

        println("§aWa sans!")

        kommand {
            command()
        }
    }
}