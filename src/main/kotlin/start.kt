fun main(args: Array<String>) {
    val factory = OperationFactoryImpl()
    factory.addOperation(Add(), Apply(), Multiply())
    var parser = StringParser("add 1\nmultiply 3\napply 2\n", factory)
    val calculator = Calculator(parser.parse())
    println("Result is ${calculator.calculate()}")
}