package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Field.ACCESSIBLE
import static dk.cngroup.university.Field.INACCESSIBLE

class FieldTest extends Specification {

    @Unroll
    "should parse '#symbol' to #field.name()"() {
        expect:
        Field.parse(symbol) == field

        where:
        symbol | field
        '.'    | ACCESSIBLE
        '0'    | INACCESSIBLE
    }

    def "should not parse invalid symbol"() {
        when:
        Field.parse('X')

        then:
        thrown(IllegalArgumentException)
    }
}
