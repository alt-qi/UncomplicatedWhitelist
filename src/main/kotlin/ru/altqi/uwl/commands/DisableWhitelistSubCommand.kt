package ru.altqi.uwl.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import ru.altqi.uwl.Whitelist

class DisableWhitelistSubCommand : AbstractCommand() {

    override val name = "off"
    override val description = "Disables whitelist."
    override val usage = "/uwl off"

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {
        if (Whitelist.isEnabled()) {
            Whitelist.disable()
            sender.sendMessage("${ChatColor.GREEN}✔${ChatColor.RESET} Whitelist has been disabled.")
        } else sender.sendMessage("${ChatColor.RED}✘${ChatColor.RESET} Whitelist is already disabled.")
    }
}