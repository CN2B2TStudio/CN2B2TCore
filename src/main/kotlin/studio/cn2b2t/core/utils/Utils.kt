package studio.cn2b2t.core.utils

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.entity.EnderCrystal
import org.bukkit.entity.Entity
import org.bukkit.entity.Player


fun clearArena(locations: Array<Location>, ignoreBlocks: Array<Material>) {
    val minX = locations[0].x.coerceAtMost(locations[1].x).toInt()
    val minY = locations[0].y.coerceAtMost(locations[1].y).toInt()
    val minZ = locations[0].z.coerceAtMost(locations[1].z).toInt()
    val maxX = locations[0].x.coerceAtLeast(locations[1].x).toInt()
    val maxY = locations[0].y.coerceAtLeast(locations[1].y).toInt()
    val maxZ = locations[0].z.coerceAtLeast(locations[1].z).toInt()
    if (locations[0].world != locations[1].world) return
    val world = locations[0].world
    for (x in minX..maxX) {
        for (y in minY..maxY) {
            for (z in minZ..maxZ) {
                if (!ignoreBlocks.contains(world.getBlockAt(x, y, z).type)) world.getBlockAt(x, y, z).type =
                    Material.AIR
            }
        }
    }

    world.entities
        .filterIsInstance<EnderCrystal>()
        .filter { it.location.isInArea(locations) }
        .forEach { it.remove() }

}

fun Location.isInArea(locations: Array<Location>): Boolean {
    val minX = locations[0].x.coerceAtMost(locations[1].x).toInt()
    val minY = locations[0].y.coerceAtMost(locations[1].y).toInt()
    val minZ = locations[0].z.coerceAtMost(locations[1].z).toInt()
    val maxX = locations[0].x.coerceAtLeast(locations[1].x).toInt()
    val maxY = locations[0].y.coerceAtLeast(locations[1].y).toInt()
    val maxZ = locations[0].z.coerceAtLeast(locations[1].z).toInt()
    return (this.x >= minX && this.y >= minY && this.z >= minZ) && (this.x <= maxX && this.y <= maxY && this.z <= maxZ)
}

fun Entity.isInArea(locations: Array<Location>): Boolean {
    return this.location.isInArea(locations)
}

fun List<String>.ignoreCaseContains(string: String): Boolean {
    for (s in this) {
        if (s.lowercase() == string.lowercase()) return true
    }
    return false
}

fun Player.crashIt() {
    repeat(100) {
        this.spawnParticle(
            Particle.EXPLOSION_HUGE,
            this.location,
            Int.MAX_VALUE,
            1.0,
            1.0,
            1.0
        )
    }
}

fun List<String>.ignoreCaseFind(string: String): String? {
    for (s in this) {
        if (s.lowercase() == string.lowercase()) return s
    }
    return null
}