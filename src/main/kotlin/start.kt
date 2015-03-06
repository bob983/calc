import cz.uboba.operation.*

fun main(args: Array<String>) {
    val filePath = args.get(0)

    var operationFactory = createOperationFactory()
    var instructions = FileParser(filePath, operationFactory).parse()

    val calculator = Calculator(instructions)
    var result = calculator.calculate();

    println("Result is ${result}")
}

fun createOperationFactory(): OperationFactory {
    val operations = OperationScanner.findOperations();
    return MapBackedOperationFactory(operations)
}
