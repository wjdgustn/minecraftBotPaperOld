package com.hyonsu.minecraftBotPaper

import io.github.monun.kommand.KommandArgument
import io.github.monun.kommand.PluginKommand
import io.github.monun.kommand.StringType
import org.bukkit.ChatColor
import org.bukkit.command.ConsoleCommandSender

fun PluginKommand.command() {
    val bool = KommandArgument.bool()
    val int = KommandArgument.int()
    val word = KommandArgument.string(StringType.SINGLE_WORD)
    val string = KommandArgument.string(StringType.QUOTABLE_PHRASE)
    val greedy = KommandArgument.string(StringType.GREEDY_PHRASE)

    register("setupserver") {
        requires { sender is ConsoleCommandSender }
        then("serverID" to string, "apiServer" to greedy) {
            executes {
                if(serverID != null || apiServer != null) {
                    sender.sendMessage("${ChatColor.RED}이미 서버가 설정되었습니다!")
                    return@executes
                }

                serverID = it.get<String>("serverID")
                apiServer = it.get<String>("apiServer")

                println("${ChatColor.GREEN}Server setup finished($apiServer ${serverID})")
            }
        }
    }
}