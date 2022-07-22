package ru.altqi.uwl


object Whitelist {

    fun enable() {
        UWL.instance.config.set("enable-whitelist", true)
        UWL.instance.saveConfig()
    }

    fun disable() {
        UWL.instance.config.set("enable-whitelist", false)
        UWL.instance.saveConfig()
    }

    fun isEnabled(): Boolean = UWL.instance.config.getBoolean("enable-whitelist")

    fun getWhitelistedPlayers(): MutableList<String> =
        UWL.instance.config.getStringList("whitelisted-players")

    fun addPlayer(playerName: String): Boolean {
        val players = getWhitelistedPlayers()
        if (playerName in players)
            return false
        players.add(playerName)
        UWL.instance.config.set("whitelisted-players", players)
        UWL.instance.saveConfig()
        return true
    }

    fun removePlayer(playerName: String): Boolean {
        val players = getWhitelistedPlayers()
        if (!players.remove(playerName))
            return false
        UWL.instance.config.set("whitelisted-players", players)
        UWL.instance.saveConfig()
        return true
    }

    fun isWhitelisted(playerName: String): Boolean {
        return playerName in getWhitelistedPlayers()
    }
}