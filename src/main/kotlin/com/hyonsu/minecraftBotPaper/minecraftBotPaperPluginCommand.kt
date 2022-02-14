package com.hyonsu.minecraftBotPaper

import io.github.monun.kommand.KommandArgument
import io.github.monun.kommand.PluginKommand
import io.github.monun.kommand.StringType
import io.github.monun.kommand.getValue
import org.bukkit.ChatColor
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

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

    register("openspoiler") {
        requires { playerOrNull != null }
        then("message" to string, "spoiler" to string) {
            executes {
                val message: String by it
                val spoiler: String by it

                openSpoiler(player, message, spoiler)
            }
        }
    }

    register("connectp") {
        requires { playerOrNull == null || isOp }
        then("players" to KommandArgument.players(), "server" to greedy) {
            executes {
                val players: Collection<Player> by it
                val server: String by it

                players.forEach {
                    waterfallStdin("connect $server ${it.name}")
                }
            }
        }
    }
}