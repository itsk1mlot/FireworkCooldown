package io.github.itsk1mlot.rocketcool

import io.github.itsk1mlot.rocketcool.command.Command
import io.github.itsk1mlot.rocketcool.command.TabComplete
import io.github.itsk1mlot.rocketcool.listener.Interact
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
    companion object {
        lateinit var instance: Main
        var toggled: Boolean = false
    }
    init {
        instance = this
    }
    override fun onEnable() {
        println("""
            ______               _           _   
            | ___ \             | |         | |  
            | |_/ /  ___    ___ | | __  ___ | |_ 
            |    /  / _ \  / __|| |/ / / _ \| __|
            | |\ \ | (_) || (__ |   < |  __/| |_ 
            \_| \_| \___/  \___||_|\_\ \___| \__|
             _____                _      _                         
            /  __ \              | |    | |                        
            | /  \/  ___    ___  | |  __| |  ___  __      __ _ __  
            | |     / _ \  / _ \ | | / _` | / _ \ \ \ /\ / /| '_ \ 
            | \__/\| (_) || (_) || || (_| || (_) | \ V  V / | | | |
             \____/ \___/  \___/ |_| \__,_| \___/   \_/\_/  |_| |_|
        """.trimIndent())
        println("[플러그인 버전: 1.2]")
        println("플러그인이 활성화됩니다!")

        // Config File Setup
        saveDefaultConfig()

        // Add Command Executor & TabCompleter
        getCommand("firework")?.setExecutor(Command())
        getCommand("firework")?.tabCompleter = TabComplete()

        // Add Event Listener
        Bukkit.getPluginManager().registerEvents(Interact(), this)
    }

    override fun onDisable() {
        println("""
            ______               _           _   
            | ___ \             | |         | |  
            | |_/ /  ___    ___ | | __  ___ | |_ 
            |    /  / _ \  / __|| |/ / / _ \| __|
            | |\ \ | (_) || (__ |   < |  __/| |_ 
            \_| \_| \___/  \___||_|\_\ \___| \__|
             _____                _      _                         
            /  __ \              | |    | |                        
            | /  \/  ___    ___  | |  __| |  ___  __      __ _ __  
            | |     / _ \  / _ \ | | / _` | / _ \ \ \ /\ / /| '_ \ 
            | \__/\| (_) || (_) || || (_| || (_) | \ V  V / | | | |
             \____/ \___/  \___/ |_| \__,_| \___/   \_/\_/  |_| |_|
        """.trimIndent())
        println("[플러그인 버전: 1.2]")
        println("플러그인이 비활성화됩니다!")
    }
}