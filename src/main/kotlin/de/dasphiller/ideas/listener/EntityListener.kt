package de.dasphiller.ideas.listener

import de.dasphiller.extensions.extensions.boost
import de.dasphiller.extensions.extensions.killEntity
import net.axay.kspigot.event.listen
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Pig
import org.bukkit.entity.ZombieVillager
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEntityEvent

object EntityListener {

    private val interactEntity = listen<PlayerInteractEntityEvent> {
        if (it.rightClicked is Pig && it.player.inventory.itemInMainHand.type == Material.DIAMOND) {
            it.rightClicked.boost(0.0, 2.5, 0.0)
        }
    }

    private val entityDamageEvent = listen<EntityDamageByEntityEvent> {
        if (it.damager.customName() == Component.text("Hans") && it.entity is LivingEntity && it.damager is ZombieVillager) {
            (it.entity as LivingEntity).killEntity()
        }
    }
}