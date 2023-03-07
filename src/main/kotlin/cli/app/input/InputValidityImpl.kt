package cli.app.input

import cli.app.utils.Coefficient
import java.io.File
import kotlin.system.exitProcess

class InputValidityImpl : InputValidity {
    override fun checkInput(key: Coefficient): Double {
        var input: String?
        var value: Double?

        do {
            print("Enter ${key.value}: ")
            input = readlnOrNull()
            value = input?.toDoubleOrNull()
            if (value == null) {
                println("Error. Expected a valid real number, got $input instead\n")
            } else if (value.toInt() == 0 && key == Coefficient.A) {
                println("Error. Expected a not-nullable value of A coefficient\n")
                value = null
            }
        } while (value == null)

        return value
    }

    override fun checkInputFile(path: String): ArrayList<Double> {
        val file = File(path)
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
}
