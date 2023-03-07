package cli.app.utils

import kotlin.math.sqrt

class QuadraticEquation(val a: Double, val b: Double, val c: Double) {
    fun solve() {
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
}
