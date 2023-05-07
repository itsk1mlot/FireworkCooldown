package io.github.itsk1mlot.rocketcool.listener

import io.github.itsk1mlot.rocketcool.Main
import io.github.itsk1mlot.rocketcool.misc.Convert
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class Interact: Listener {
    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        val player = event.player
        val seconds = Main.instance.config.getInt("cooldown")

        if (player.inventory.itemInMainHand.type == Material.FIREWORK_ROCKET || player.inventory.itemInOffHand.type == Material.FIREWORK_ROCKET) {
            if (player.hasCooldown(Material.FIREWORK_ROCKET)) {
                player.sendMessage(Component.text("§6[FireworkCooldown] §c아직 쿨다운이 ${Convert.toSeconds(player.getCooldown(Material.FIREWORK_ROCKET))}초 남았습니다!"))
            } else {
                player.setCooldown(Material.FIREWORK_ROCKET, Convert.toTick(seconds))
            }
        }
    }
}