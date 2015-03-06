import cz.uboba.operation.*

fun main(args: Array<String>) {
    if(args.isEmpty()) {
        println("Please add path to file with instructions as a first (and only) param")
        return;
    }
    val filePath = args.get(0)

    var operationFactory = createOperationFactory()
    var instructions = FileParser(operationFactory).parse(filePath)

    val calculator = Calculator(instructions)
    val result = calculator.calculate();

    InstructionsPrinter.print(instructions)

    println("Result is ${result}")
}

fun createOperationFactory(): OperationFactory {
    val operations = OperationScanner.findOperations();
    return MapBackedOperationFactory(operations)
}
