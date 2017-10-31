package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Direction.*

class DirectionTest extends Specification {

    @Unroll
    "should turn left from #initial to #left"() {
        expect:
        initial.getLeft() == left

        where:
        initial | left
        NORTH   | WEST
        EAST    | NORTH
        SOUTH   | EAST
        WEST    | SOUTH
    }

    @Unroll
    "should turn right from #initial to #right"() {
        expect:
        initial.getRight() == right

        where:
        initial | right
        NORTH   | EAST
        EAST    | SOUTH
        SOUTH   | WEST
        WEST    | NORTH
    }

    @Unroll
    "should parse '#symbol' to #direction"() {
        expect:
        Direction.parse(symbol) == direction

        where:
        symbol | direction
        'N'    | NORTH
        'E'    | EAST
        'S'    | SOUTH
        'W'    | WEST
    }

    def "should not parse invalid symbol"() {
        when:
        Direction.parse('X')

        then:
        thrown(IllegalArgumentException)
    }
}
