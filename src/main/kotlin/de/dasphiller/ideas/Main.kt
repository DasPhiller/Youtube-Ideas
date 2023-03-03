package de.dasphiller.ideas

import de.dasphiller.ideas.listener.EntityListener
import net.axay.kspigot.main.KSpigot

class Main : KSpigot() {

    override fun startup() {
        logger.info("The Plugin was enabled!")
        EntityListener
    }

    override fun shutdown() {
        logger.info("The Plugin was disabled!")
    }
}
