import cz.uboba.operation.MapBackedOperationFactory
import cz.uboba.operation.Operation
import spock.lang.Specification

class OperationFactoryImplTest extends Specification {

    def "stores operation"() {
        setup:
        def operation = Mock(Operation)
        operation.operationName() >> 'op1'

        when:
        def factory = new MapBackedOperationFactory([operation]);

        then:
        factory.get("op1") == operation
    }

    def "throws exception for non-existing operation"() {
        setup:
        def factory = new MapBackedOperationFactory([]);

        when:
        factory.get("op1")

        then:
        thrown(UnsupportedOperationException)
    }

}