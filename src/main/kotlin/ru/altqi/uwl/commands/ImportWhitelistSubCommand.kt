package ru.altqi.uwl.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import ru.altqi.uwl.UWL
import ru.altqi.uwl.Whitelist

class ImportWhitelistSubCommand : AbstractCommand() {
    
    override val name = "import"
    override val description = "Transfers players from Minecraft whitelist to UWL."
    override val usage = "/uwl import"

    override fun execute(sender: CommandSender, command: Command, args: Array<out String>) {
        val playerNames = UWL.instance.server.whitelistedPlayers.map { it.name }
        playerNames.forEach { if (it != null && !Whitelist.isWhitelisted(it)) Whitelist.addPlayer(it)}
        sender.sendMessage(
            "${ChatColor.GREEN}✔${ChatColor.RESET} Players from Minecraft whitelist have been successfully transferred to UWL."
        )
    }
}