import spock.lang.Specification


class OperationFactoryImplTest extends Specification {

    def "stores operation"() {
        setup:
        def operation = Mock(Operation)
        operation.operationName() >> 'op1'

        def factory = new OperationFactoryImpl();

        when:
        factory.addOperation(operation)

        then:
        factory.get("op1") == operation
    }

    def "throws exception for non-existing operation"() {
        setup:
        def factory = new OperationFactoryImpl();

        when:
        factory.get("op1")

        then:
        thrown(UnsupportedOperationException)
    }

}