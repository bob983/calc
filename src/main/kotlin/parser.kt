import java.nio.file.Files
import java.io.File
import cz.uboba.operation.OperationFactory

trait InstructionParser {
    fun parse(): List<Instruction>
}

class StringParser(val inputString: String, val operationFactory: OperationFactory) : InstructionParser {

    override fun parse(): List<Instruction> {
        val instructions = parseInstructions(inputString)
        moveLastItemToFront(instructions)
        return instructions
    }

    fun parseInstructions(stringOfOperations: String): MutableList<Instruction> {

        return stringOfOperations
                .split("\n")
                .map { line ->
                    val (operationName, value) = line.split(" ")
                    val operation = operationFactory.get(operationName)
                    InstructionImpl(operation, value.toInt())
                }
                .toLinkedList()
    }

    fun <T> moveLastItemToFront(list: MutableList<T>) {
        val apply = list.remove(list.size() - 1)
        list.add(0, apply)
    }

}

class FileParser(val filePath: String, val operationFactory: OperationFactory) : InstructionParser {

    override fun parse(): List<Instruction> {
        val fileContent = File(filePath).readText()
        return StringParser(fileContent, operationFactory).parse()
    }

}