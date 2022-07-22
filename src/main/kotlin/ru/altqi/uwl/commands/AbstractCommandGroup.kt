package ru.altqi.uwl.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

abstract class AbstractCommandGroup(private val subCommands: List<AbstractCommand>) : AbstractCommand() {

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {}

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isNotEmpty()) {
            val subCommandArgs = args.toMutableList()
            val subCommandName = subCommandArgs.removeAt(0)
            subCommands.find { it.name == subCommandName }
                ?.execute(sender, command, subCommandArgs.toTypedArray())
        } else {
            execute(sender, command, args)
        }

        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String>? {
        val subCommandArgs = args.toMutableList()
        val subCommandName = subCommandArgs.removeAt(0)

        return if (args.size == 1) {  // size of args always bigger than 1, because in the other case onTabComplete is not called at all.
            subCommands.map { it.name }
                .filter { it.contains(subCommandName, ignoreCase = true) }
                .toMutableList()
        } else {
            subCommands.find { it.name.contains(subCommandName, ignoreCase = true) }
                ?.onTabComplete(sender, command, alias, subCommandArgs.toTypedArray())
        }
    }
}