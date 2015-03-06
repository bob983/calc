object InstructionsPrinter {

    public fun print(instructions: List<Instruction>) {
        instructions.forEach { println(it.toString()) }
    }

}