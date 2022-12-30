package studio.cn2b2t.core.command

annotation class CommandInfo(
    val name: String,
    val aliases: Array<String> = [],
    val permission: String = "NonePermission",
    val playerOnly: Boolean = false,
    val opOnly: Boolean = false
)