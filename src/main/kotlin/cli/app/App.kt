package cli.app

import cli.app.objects.Descriptions
import cli.app.options.OptionsImpl
import kotlinx.cli.* // ktlint-disable no-wildcard-imports

fun main(args: Array<String>) {
    val parser = ArgParser(App.NAME)
    val options = OptionsImpl()

    val version by parser.option(
        ArgType.Boolean,
        shortName = "v",
        description = App.VERSION,
    ).default(false)

    val inputFile by parser.option(
        ArgType.String,
        shortName = "f",
        description = Descriptions.NON_INTERACTIVE_MODE,
    ).default("")

    val noArgs by parser.option(
        ArgType.Boolean,
        description = Descriptions.INTERACTIVE_MODE,
    ).default(args.isEmpty())
    parser.parse(args)

    if (version) options.showVersion(App.VERSION)
    if (noArgs) options.switchToInteractiveMode()
    if (inputFile.isNotEmpty()) options.switchToNonInteractiveMode(inputFile)
}
object App {
    const val NAME = "equation"
    const val VERSION = "1.0.0"
}
