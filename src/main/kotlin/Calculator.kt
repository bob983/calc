class Calculator(val instructions: List<Instruction>) {
    public fun calculate(): Int {
        return instructions.fold(0) {(total: Int, next: Instruction) ->
            println(next)
            next.execute(total)
        }
    }
}
