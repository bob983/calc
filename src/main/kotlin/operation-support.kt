package cz.uboba.operation

import org.reflections.Reflections

trait OperationFactory {
    fun get(operationName: String): Operation
}

public class MapBackedOperationFactory(initialOperations: Collection<Operation>) : OperationFactory {
    val operationsMap: MutableMap<String, Operation> = hashMapOf();

    {
        initialOperations.forEach { operationsMap.put(it.operationName(), it) }
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

/**
 * Scans classpath and looks for implementations of Operation interface
 */
object OperationScanner {
    public fun findOperations(): Collection<Operation> {
        return Reflections()
                .getSubTypesOf(javaClass<Operation>())
                .map { it.newInstance() }
    }
}
