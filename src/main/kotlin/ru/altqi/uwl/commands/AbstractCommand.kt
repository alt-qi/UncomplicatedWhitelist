package ru.altqi.uwl.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

abstract class AbstractCommand : CommandExecutor, TabCompleter {
    abstract val name: String

    open val usage = "Usage not provided."
    open val description = "No description."

    abstract fun execute(sender: CommandSender, command: Command, args: Array<out String>)

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String>? {
        return mutableListOf()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        execute(sender, command, args)
        return true
    }
}