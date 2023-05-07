package io.github.itsk1mlot.rocketcool.command

import io.github.itsk1mlot.rocketcool.Main
import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class Command: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args?.get(0).equals("reload")) {
            Main.instance.reloadConfig()
            sender.sendMessage(Component.text("§6[FireworkCooldown] §aConfig 파일이 리로드되었습니다!"))
            return true
        } else if (args?.get(0).equals("toggle")) {
            if (Main.toggled) {
                Main.toggled = false
                val cooldown = Main.instance.config.get("cooldown")
                sender.sendMessage(Component.text("§6[FireworkCooldown] §a이제 폭죽로켓은 ${cooldown}초의 쿨타임을 가집니다. &7(무시 권한: firework.bypass)"))
            } else if (!Main.toggled) {
                Main.toggled = true
                sender.sendMessage(Component.text("§6[FireworkCooldown] §c이제 폭죽로켓은 쿨타임을 가지지 않습니다."))
            }
        }
        return false
    }
}