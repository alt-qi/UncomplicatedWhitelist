package ru.altqi.uwl.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class UWLCommandGroup(private val subCommands: List<AbstractCommand> = listOf(
    AddToWhitelistSubCommand(),
    RemoveFromWhitelistSubCommand(),
    GetWhitelistSubCommand(),
    EnableWhitelistSubCommand(),
    DisableWhitelistSubCommand(),
    ImportWhitelistSubCommand(),
    ReloadSubCommand()
)) : AbstractCommandGroup(subCommands) {

    override val name = "uwl"

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {
        sender.sendMessage("${ChatColor.GOLD}${ChatColor.BOLD}Available commands:${ChatColor.RESET} \n" + subCommands.joinToString(
            separator = "\n",
            transform = { "  ${it.usage}${ChatColor.GRAY} - ${it.description}${ChatColor.RESET}" }
        ))
    }
}