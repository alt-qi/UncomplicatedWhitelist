package ru.altqi.uwl.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import ru.altqi.uwl.Whitelist

class GetWhitelistSubCommand : AbstractCommand() {

    override val name = "list"
    override val description = "Displays whitelisted players."
    override val usage = "/uwl list"

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {
        val list = Whitelist.getWhitelistedPlayers()
        if (list.isNotEmpty())
            sender.sendMessage(
                "${ChatColor.GOLD}${ChatColor.BOLD}Whitelisted players:${ChatColor.RESET}\n" + list.joinToString(
                    separator = "\n",
                    transform = { "${ChatColor.GOLD} - ${ChatColor.RESET}$it" }
                )
            )
        else
            sender.sendMessage("${ChatColor.RED}✘${ChatColor.RESET} Whitelist is empty.")

    }
}