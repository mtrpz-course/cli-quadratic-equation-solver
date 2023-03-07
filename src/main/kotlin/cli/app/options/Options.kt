package cli.app.options

interface Options {
    fun showVersion(version: String)
    fun switchToInteractiveMode()
    fun switchToNonInteractiveMode(path: String)
}