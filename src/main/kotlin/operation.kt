package cz.uboba.operation

import org.reflections.Reflections
import org.reflections.ReflectionUtils

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
    fun get(operationName: String): Operation
}

class OperationFactoryImpl(initialOperations: List<Operation>) : OperationFactory {
    val operationsMap: MutableMap<String, Operation> = hashMapOf();

    {
        initialOperations.forEach {
            operationsMap.put(it.operationName(), it)
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

object OperationScanner {

    public fun findOperations(): List<Operation> {
        val reflections = Reflections("")
        val operations = reflections.getSubTypesOf(javaClass<Operation>())
        return operations
                .map { it.newInstance() }
    }

}
