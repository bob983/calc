import spock.lang.Specification


class StringParserTest extends Specification {

    def operationFactory = Mock(OperationFactory)


    def "well formed string is parsed to operations"() {
        setup:
        def dummyOperation = Mock(Operation)
        operationFactory.get("operation") >> dummyOperation

        when:
        def instructions = parse("operation 23")

        then:
        instructions.size() == 1
        instructions.get(0).getOperation() == dummyOperation
        instructions.get(0).getNumber() == 23
    }

    def "moves last operation to the beginning"() {
        setup:
        def op1 = Mock(Operation)
        def apply = Mock(Operation)
        operationFactory.get("op1") >> op1
        operationFactory.get("apply") >> apply

        when:
        def instructions = parse("op1 1\napply 2")

        then:
        instructions.size() == 2
        instructions.get(0).getOperation() == apply
        instructions.get(1).getOperation() == op1

    }

    def parse(String input) {
        new StringParser(input, operationFactory).parse()
    }

}