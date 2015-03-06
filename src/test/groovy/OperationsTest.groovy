import cz.uboba.operation.*
import spock.lang.Specification

class OperationsTest extends Specification {

    def "add operation"() {
        setup:
        def add = new Add()
        expect:
        add.apply(op1, op2) == result

        where:
        op1| op2| result
         0 | 1  | 1
        -1 |-1  |-2
         2 | 2  | 4
    }

    def "multiply operation"() {
        setup:
        def multiply = new Multiply()
        expect:
        multiply.apply(op1, op2) == result

        where:
        op1| op2| result
        0  | 1  | 0
        1  |-1  |-1
        2  | 2  | 4
    }

    def "apply operation"() {
        setup:
        def apply = new Apply()
        expect:
        apply.apply(0, op1) == result

        where:
        op1| result
         0 | 0
        -1 |-1
         2 | 2
    }

}
