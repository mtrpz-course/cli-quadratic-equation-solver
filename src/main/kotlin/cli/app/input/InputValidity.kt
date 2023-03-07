package cli.app.input

import cli.app.utils.Coefficient

interface InputValidity {
    fun checkInput(key: Coefficient): Double

    fun checkInputFile(path: String): ArrayList<Double>
}
