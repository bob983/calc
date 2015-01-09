import spock.lang.Specification


class CalculatorTest extends Specification {

    def "execute operation and return result"() {
        setup:
        def instr1 = Mock(Instruction)

        when:
        calculate([instr1])

        then:
        1 * instr1.execute(0)
    }

    def "carry result of previous operation"() {
        setup:
        def instr1 = Mock(Instruction)
        def instr2 = Mock(Instruction)
        instr1.execute(_) >> 1
        instr2.execute(_) >> 4

        when:
        def result = calculate([instr1, instr2])

        then:
        result == 4
    }

    def calculate(List<Instruction> instructions) {
        new Calculator(instructions).calculate()
    }

}