package cli.app.options

import cli.app.utils.Coefficient
import cli.app.utils.QuadraticEquation
import cli.app.input.InputValidityImpl

class OptionsImpl() : Options {

    private val inputValidity = InputValidityImpl()

    override fun showVersion(version: String) {
        println(version)
    }

    override fun switchToInteractiveMode() {
        val a = inputValidity.checkInput(Coefficient.A)
        val b = inputValidity.checkInput(Coefficient.B)
        val c = inputValidity.checkInput(Coefficient.C)
        val equation = QuadraticEquation(a, b, c)
        equation.solve()
    }

    override fun switchToNonInteractiveMode(path: String) {
        val coef = inputValidity.checkInputFile(path)
        val a = coef[0]
        val b = coef[1]
        val c = coef[2]
        val equation = QuadraticEquation(a, b, c)
        equation.solve()
    }
}
