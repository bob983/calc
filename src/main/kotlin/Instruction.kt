trait Instruction {
    fun execute(input: Int): Int
}

class InstructionImpl(val operation: Operation, val number: Int) : Instruction {
    public override fun execute(input: Int): Int {
        return operation.apply(input, number)
    }

    override fun toString(): String {
        return "${operation.operationName()} ${number}"
    }
}
