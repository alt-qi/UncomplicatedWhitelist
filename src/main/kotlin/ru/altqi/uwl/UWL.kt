package ru.altqi.uwl

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import ru.altqi.uwl.commands.UWLCommandGroup

class UWL : JavaPlugin() {

    override fun onEnable() {
        saveDefaultConfig()
        instance = this
        getCommand("uwl")!!.setExecutor(UWLCommandGroup())
        Bukkit.getPluginManager().registerEvents(PlayerLoginListener(), this)
    }

    companion object {
        lateinit var instance: UWL
            private set
    }
}