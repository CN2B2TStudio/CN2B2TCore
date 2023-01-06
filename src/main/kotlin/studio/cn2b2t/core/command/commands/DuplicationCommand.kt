package studio.cn2b2t.core.command.commands

@CommandInfo(
    name = "dupe",
    aliases = ["fz", "duplication"],
    playerOnly = true,
    permission = "studio.cn2b2t.core.dupe.fz"
)
object DuplicationCommand : BaseCommand() {
    override fun execute(sender: CommandSender, args: Array<out String>, main: Main) {
        val item = (sender as HumanEntity).inventory.itemInMainHand
        if (!sender.hasPermission("studio.cn2b2t.core.dupe.fz")) return
        repeat(3) {
            if (sender.inventory.containsAir()) {
                sender.inventory.addItem(item)
            } else {
                sender.world.dropItem(sender.location, item)
            }
        }
    }

    private fun ItemStack?.isAir(): Boolean {
        if (this == null) return true
        return if (this.type == null) true else this.type == Material.AIR
    }

    private fun Inventory.containsAir(): Boolean {
        this.forEach {
            if (it.isAir()) return true
        }
        return false
    }
}
