package ru.altqi.uwl

import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerPreLoginEvent

class PlayerLoginListener : Listener {

    @EventHandler
    fun onProfileWhitelistVerify(event: AsyncPlayerPreLoginEvent) {
        if (!Whitelist.isEnabled()) return

        val playerName = event.playerProfile.name
        val msg = ChatColor.translateAlternateColorCodes('§',
            UWL.instance.config.getString("not-whitelisted-message", "You are not whitelisted.")!!,
        )

        if (playerName != null && Whitelist.isWhitelisted(playerName)) {
            event.allow()
        } else {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, Component.text(msg))
        }
    }
}