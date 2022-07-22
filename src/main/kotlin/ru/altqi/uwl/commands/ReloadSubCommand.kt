package ru.altqi.uwl.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import ru.altqi.uwl.UWL

class ReloadSubCommand : AbstractCommand() {

    override val name = "reload"
    override val description = "Reloads plugin config."
    override val usage = "/uwl reload"

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {
        UWL.instance.reloadConfig()
        sender.sendMessage("${ChatColor.GREEN}✔${ChatColor.RESET} Config has been reloaded.")
    }
}