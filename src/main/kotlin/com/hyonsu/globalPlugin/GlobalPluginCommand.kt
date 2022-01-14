package com.hyonsu.globalPlugin

import io.github.monun.kommand.*

fun PluginKommand.command() {
    val bool = KommandArgument.bool()
    val int = KommandArgument.int()
    val word = KommandArgument.string(StringType.SINGLE_WORD)
    val string = KommandArgument.string(StringType.QUOTABLE_PHRASE)
    val greedy = KommandArgument.string(StringType.GREEDY_PHRASE)

    register("my", "myalias") {
        then("age") {
            then("age" to int) {
                then("name" to string) {
                    executes {
                        val age: Int by it
                        val name: String by it
                        sender.sendMessage("${name}의 나이는 ${age}살")
                    }
                }
            }
        }
    }
}