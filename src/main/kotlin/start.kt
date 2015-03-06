import cz.uboba.operation.*

fun main(args: Array<String>) {
    val instructions = OperationScanner.findOperations();
    val factory = OperationFactoryImpl(instructions)
    var parser = StringParser("add 1\nmultiply 3\napply 2\n", factory)
    val calculator = Calculator(parser.parse())
    println("Result is ${calculator.calculate()}")
}