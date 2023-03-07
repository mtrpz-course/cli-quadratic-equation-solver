package cli.app.objects

object Descriptions {
    const val INTERACTIVE_MODE = """ no-args
            |Interactive mode.
            |Read coefficients from the console one by one.
        """
    const val NON_INTERACTIVE_MODE = """ file.txt
            |Non-interactive mode.
            |Read coefficients from the 1-st line of TXT-file in format: "a\sb\sc\n"
            |Example: file.txt
             1. 1 0 0
             2. ------------------
        """
}