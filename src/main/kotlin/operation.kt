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
