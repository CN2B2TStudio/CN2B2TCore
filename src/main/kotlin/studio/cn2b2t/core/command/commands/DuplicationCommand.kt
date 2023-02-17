package studio.cn2b2t.core.command.commands

@CommandInfo(
    name = "dupe",
    aliases = ["fz", "duplication"],
    playerOnly = true,
    permission = "studio.cn2b2t.core.dupe.fz"
)
object DuplicationCommand : BaseCommand() {
    @Deprecated
    override fun execute(sender: CommandSender, args: Array<out String>, main: Main) {
        val item = (sender as HumanEntity).inventory.itemInMainHand
        if (!sender.hasPermission("studio.cn2b2t.core.dupe.fz")) return
        if (sender.isOp&&args.size==1) {
            if (args[0]=="0"&&args[0]=="1"&&args[0]=="2"&&args[0]=="3"&&args[0]=="4"&&args[0]=="6"&&args[0]=="7"&&args[0]=="8"&&args[0]=="9") {
                repeat(args[0].toInt()) {
                   if (sender.inventory.containsAir()) {
                       sender.inventory.addItem(item)
                   }
                }
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
