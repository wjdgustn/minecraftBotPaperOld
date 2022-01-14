package com.hyonsu.minecraftBotPaper

import org.bukkit.entity.Player
import java.net.URL
import java.net.URLEncoder

var apiServer: String? = null
var serverID: String? = null

fun playerJoin(player: Player): String {
    if(apiServer == null || serverID == null) return "noapi"
    return URL("$apiServer/api/user/join?server=$serverID&name=${player.name}&uuid=${player.uniqueId}").readText()
}

fun playerLeft(player: Player): String {
    if(apiServer == null || serverID == null) return "noapi"
    return URL("$apiServer/api/user/left?server=$serverID&name=${player.name}&uuid=${player.uniqueId}").readText()
}

fun sendChat(player: Player, content: String): String {
    if(apiServer == null || serverID == null) return "noapi"
    return URL("$apiServer/api/chat?server=$serverID&name=${player.name}&uuid=${player.uniqueId}&content=${URLEncoder.encode(content)}").readText()
}