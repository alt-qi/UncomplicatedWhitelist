package ru.altqi.uwl.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import ru.altqi.uwl.Whitelist

class RemoveFromWhitelistSubCommand : AbstractCommand() {

    override val name = "remove"
    override val description = "Removes specified player from whitelist."
    override val usage = "/uwl remove <player>"

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {
        val playerName = args.getOrNull(0)
        if (playerName != null)
            if (Whitelist.removePlayer(playerName))
                sender.sendMessage("${ChatColor.GREEN}✔${ChatColor.RESET} Player has been removed from whitelist.")
            else
                sender.sendMessage("${ChatColor.RED}✘${ChatColor.RESET} This player is not whitelisted.")
        else
            sender.sendMessage("${ChatColor.RED}✘${ChatColor.RESET} Please specify a player.")
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String> {
        val arg = args[0]
        return Whitelist.getWhitelistedPlayers()
            .filter { it.contains(arg, ignoreCase = true) }
            .toMutableList()
    }
}