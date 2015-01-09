import java.nio.file.Files
import java.io.File

trait InstructionParser {
    fun parse(): List<Instruction>
}

class StringParser(val inputString: String, val operationFactory : OperationFactory) : InstructionParser {

    override fun parse(): List<Instruction> {
        val instructions = parseInstructions(inputString)
        moveLastItemToFront(instructions)
        return instructions
    }

    fun parseInstructions(stringOfOperations: String): MutableList<Instruction> {

        fun parse(line : String) : Instruction {
            val chunks = parseInstruction(line)
            val operation = operationFactory.get(chunks.first)
            val operand = chunks.second.toInt()
            return InstructionImpl(operation, operand)
        }

        return stringOfOperations
                .split("\n")
                .map(::parse)
                .toLinkedList()
    }

    fun <T> moveLastItemToFront(list : MutableList<T>) {
        val apply = list.remove(list.size() - 1)
        list.add(0, apply)
    }

    fun parseInstruction(str: String): Pair<String, String> {
        val chunks = str.split(" ")
        return Pair(chunks[0], chunks[1])
    }
}

class FileParser(val filePath : String, val operationFactory : OperationFactory) : InstructionParser {

    override fun parse(): List<Instruction> {
        val fileContent = File(filePath).readText()
        return StringParser(fileContent, operationFactory).parse()
    }

}