package ru.altqi.uwl.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import ru.altqi.uwl.Whitelist

class EnableWhitelistSubCommand : AbstractCommand() {

    override val name = "on"
    override val description = "Enables whitelist."
    override val usage = "/uwl on"

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {
        if (!Whitelist.isEnabled()) {
            Whitelist.enable()
            sender.sendMessage("${ChatColor.GREEN}✔${ChatColor.RESET} Whitelist has been enabled.")
        } else sender.sendMessage("${ChatColor.RED}✘${ChatColor.RESET} Whitelist is already enabled.")
    }
}