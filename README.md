# UncomplicatedWhitelist

Minecraft whitelist plugin that uses player names for identification instead of UUIDs.

[Would you like to see the README in Russian? 👈](https://github.com/alt-qi/UncomplicatedWhitelist/blob/main/README_ru.md)

## Why do I need this plugin? 

Sometimes when creating a private server, you may have encountered that when trying to add **new** player to the built-in whitelist,
you may have seen a message like `This player does not exist`.

That's because since the update `1.8` the built-in Minecraft whitelist identifies players **not by their name but by their UUID** (unique 
identifier). The server recognizes a player's UUID the first time he logs in, so if he has never logged into your server you will not be able to add
him in your whitelist. 

UUID identification can also be a problem if a player plays an unlicensed version of Minecraft through unofficial launchers. Different launchers can use
can use different algorithms to generate player's UUID, so it's possible that while playing with the same nickname but from different launchers you may have
different UUIDs assigned to you, which can cause unexpected behavior of the whitelist.

## This plugin solves the above problems. But how?

It's quite simple - the plugin lets you go back to the time when there was no UUIDs...
**When identification was by name.**

To put it another way, the plugin provides its own whitelist, where player identification is not by UUID but by name.

## Commands

 + `/uwl add <player>` - Adds the specified player to the whitelist.
 + `/uwl remove <player>` - Removes the specified player from the whitelist.
 + `/uwl list` - Displays a list of whitelisted players
 + `/uwl on` - Enables the whitelist.
 + `/uwl off` - Disables the whitelist.
 + `/uwl import` - Imports all players from the Minecraft whitelist. 
 + `/uwl reload` - Reloads the config.
 
**P.S.:** There is one permission in the entire plugin: `uwl.operate`. It allows you to use all the commands of plugin.
