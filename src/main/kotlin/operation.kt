trait Operation {
    fun operationName(): String
    fun apply(operandA: Int, operandB: Int): Int
}

class Add : Operation {
    override fun apply(operandA: Int, operandB: Int): Int {
        return operandA + operandB
    }

    override fun operationName(): String {
        return "add"
    }
}

class Apply : Operation {
    override fun apply(operandA: Int, operandB: Int): Int {
        return operandB
    }

    override fun operationName(): String {
        return "apply"
    }
}

class Multiply : Operation {
    override fun operationName(): String {
        return "multiply"
    }

    override fun apply(operandA: Int, operandB: Int): Int {
        return operandA * operandB
    }

}

trait OperationFactory {
    fun addOperation(vararg operations: Operation)
    fun get(operationName: String): Operation
}

class OperationFactoryImpl : OperationFactory {
    val operationsMap: MutableMap<String, Operation> = hashMapOf()

    public override fun addOperation(vararg operations: Operation) {
        for (operation in operations) {
            operationsMap.put(operation.operationName(), operation)
        }
    }

    public override fun get(operationName: String): Operation {
        val operation: Operation? = operationsMap.get(operationName)
        if (operation == null) {
            throw UnsupportedOperationException("Unknown operation : ${operationName}")
        } else {
            return operation
        }
    }
}
