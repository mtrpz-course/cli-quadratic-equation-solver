package cli.app

import kotlinx.cli.* // ktlint-disable no-wildcard-imports
import java.util.Scanner
import kotlin.math.sqrt

val scanner = Scanner(System.`in`)
fun main(args: Array<String>) {
    val parser = ArgParser(App.NAME)
    val version by parser.option(
        ArgType.Boolean,
        shortName = "v",
        description = App.VERSION,
    ).default(false)
    parser.parse(args)

    if (version) {
        println(App.VERSION)
    }
    if (args.isEmpty()) {
        switchToInteractiveMode()
    }
}
fun switchToInteractiveMode() {
    val a = checkCoefForValidity(Coefficient.A)
    val b = checkCoefForValidity(Coefficient.B)
    val c = checkCoefForValidity(Coefficient.C)

    println("Equation: ($a) * x^2 + ($b) * x + ($c) = 0")

    val descriminant = b * b - 4 * a * c
    val x1 = (-b + sqrt(descriminant)) / (2 * a)
    val x2 = (-b - sqrt(descriminant)) / (2 * a)

    if (descriminant == 0.0) {
        println("There is only one root: $x1")
    } else if (descriminant > 0) {
        println("There are two roots: \n ${Coefficient.X}1 = $x1  \n ${Coefficient.X}2 = $x2")
    } else if (descriminant < 0) println("There are no roots")
}
fun checkCoefForValidity(coef: Coefficient): Double {
    var input: String?
    var value: Double?

    do {
        print("Enter ${coef.value}: ")
        input = readlnOrNull()
        value = input?.toDoubleOrNull()
        if (value == null) println("Error. Expected a valid real number, got $input instead\n")
    } while (value == null)

    return value
}
object App {
    const val NAME = "equation"
    const val VERSION = "1.0.0"
}

enum class Coefficient(val value: String) {
    A("a"),
    B("b"),
    C("c"),
    X("x"),
}
