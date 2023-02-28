# Quadratic Equation Solver (QES)
This is lab 1 for the course "Software development methodology" at the Kiev Polytechnic Institute.
> A multiplatform CLI-application written in Kotlin, using [kotlinx-cli](https://github.com/Kotlin/kotlinx-cli) **library**.
>
> Download [_here_]().
-------------------------------
## Description
The application solves quadratic equations of the form `ax^2 + bx + c = 0` and prints the roots of the equation.
There are two mods to use the application:
1. **Interactive mode** - the application asks the user to enter the coefficients of the equation and prints the roots.
2. **Non-interactive mode** - the application takes the coefficients from input TXT-file argument and prints the roots.

## Technologies Used
- **IDE**: IntelliJ IDEA
- **Programming language**: Kotlin
- **Build system**: Gradle
- **Libraries**: kotlinx-cli

## Installation
### I variant:
1. Download the application from [_here_]().
2. Run the Jar-file from the command line:
```bash
java -jar path/to/file/cli-quadratic-solver-1.0-SNAPSHOT.jar
```
### II variant:
1. Clone the repository:
```bash
git clone https://github.com/mtrpz-course/cli-quadratic-equation-solver.git
```
2. Build the project:
```bash
gradle build
```
3. Assembly jar file conatining main classes and dependencies:
```bash
gradle jar
```
4. Distribute the package, which contains the jar file and the script for running the application,to the auto-created `dest` directory
```bash
gradle packageDistribution
```
5. Run the application:
```bash
cd dest && source ./equation.sh
equation -h
```

## Usage
For more information about the application, run the following command:
```bash
equation -h
Usage: equation options_list
Options: 
    --version, -v [false] -> 1.0.0 
    --inputFile, -f [] -> Input file { String }
    --help, -h -> Usage info 

```
