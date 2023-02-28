package cli.app

import kotlinx.cli.* // ktlint-disable no-wildcard-imports
import java.io.File
import java.util.Scanner
import kotlin.math.sqrt
import kotlin.system.exitProcess

val scanner = Scanner(System.`in`)
fun main(args: Array<String>) {
    val parser = ArgParser(App.NAME)
    val version by parser.option(
        ArgType.Boolean,
        shortName = "v",
        description = App.VERSION,
    ).default(false)
    val inputFile by parser.option(
        ArgType.String,
        shortName = "f",
        description = """ file.txt
            |Non-interactive mode.  
            |Read coefficients from the 1-st line of TXT-file in format: "a\sb\sc\n"
            |Example: file.txt
             1. 1 0 0
             2. ------------------
        """,
    ).default("")
    val noArgs by parser.option(
        ArgType.Boolean,
        description = """ no-args
            |Interactive mode.
            |Read coefficients from the console one by one.
        """,
    ).default(args.isEmpty())
    parser.parse(args)

    if (version) {
        println(App.VERSION)
    }
    if (noArgs) {
        switchToInteractiveMode()
    }
    if (inputFile.isNotEmpty()) {
        val inputData = checkInputFileForValidity(File(inputFile))
        switchToNonInteractiveMode(inputData)
    }
}
fun switchToInteractiveMode() {
    val a = checkInputForValidity(Coefficient.A)
    val b = checkInputForValidity(Coefficient.B)
    val c = checkInputForValidity(Coefficient.C)
    solveQuadraticEquation(a, b, c)
}
fun switchToNonInteractiveMode(coef: ArrayList<Double>) {
    val a = coef[0].toDouble()
    val b = coef[1].toDouble()
    val c = coef[2].toDouble()
    solveQuadraticEquation(a, b, c)
}
fun checkInputForValidity(coef: Coefficient): Double {
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

fun checkInputFileForValidity(file: File): ArrayList<Double> {
    if (!file.exists()) {
        println("Error. File ${file.name} does not exist")
        exitProcess(1)
    }
    val input = file.readText().trim().split(" ")
    if (input.size != 3) {
        println("Error. Expected 3 coefficients, got ${input.size} instead")
        exitProcess(1)
    }
    val a = input[0].toDoubleOrNull()
    val b = input[1].toDoubleOrNull()
    val c = input[2].toDoubleOrNull()

    if (a == null || b == null || c == null) {
        println("Error. Expected a valid real number, got $input instead")
        exitProcess(1)
    } else {
        return arrayListOf(a, b, c)
    }
}

fun solveQuadraticEquation(a: Double, b: Double, c: Double) {
    val descriminant = b * b - 4 * a * c
    val x1 = (-b + sqrt(descriminant)) / (2 * a)
    val x2 = (-b - sqrt(descriminant)) / (2 * a)
    println("Equation: ($a)*x^2 + ($b)*x + ($c) = 0")

    if (descriminant == 0.0) {
        println("There is only one root: $x1")
    } else if (descriminant > 0) {
        println("There are two roots: \n x1 = $x1  \n x2 = $x2")
    } else if (descriminant < 0) println("There are no roots")
}
object App {
    const val NAME = "equation"
    const val VERSION = "1.0.0"
}
