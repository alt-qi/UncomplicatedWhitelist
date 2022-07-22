package ru.altqi.uwl.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import ru.altqi.uwl.UWL
import ru.altqi.uwl.Whitelist

class AddToWhitelistSubCommand : AbstractCommand() {

    override val name = "add"
    override val description = "Adds specified player to whitelist."
    override val usage = "/uwl add <player>"

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {
        val playerName = args.getOrNull(0)
        if (playerName != null)
            if (Whitelist.addPlayer(playerName))
                sender.sendMessage("${ChatColor.GREEN}✔${ChatColor.RESET} Player has been added to whitelist.")
            else
                sender.sendMessage("${ChatColor.RED}✘${ChatColor.RESET} This player is already whitelisted.")
        else
            sender.sendMessage("${ChatColor.RED}✘${ChatColor.RESET} Please specify a player.")
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String> {
        val arg = args[0]
        val players = Whitelist.getWhitelistedPlayers()
        return UWL.instance.server.onlinePlayers
            .map { it.name }
            .filter { it !in players && it.contains(arg, ignoreCase = true)}
            .toMutableList()
    }
}