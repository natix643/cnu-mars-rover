package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Action.*

class ActionTest extends Specification {

    @Unroll
    "should parse #symbol to #action"() {
        expect:
        Action.parse(symbol) == action

        where:
        symbol | action
        'L'    | LEFT
        'R'    | RIGHT
        'F'    | FORWARD
        'B'    | BACKWARD
    }

    def "should not parse invalid symbol"() {
        when:
        Action.parse('X')

        then:
        thrown(IllegalArgumentException)
    }
}
