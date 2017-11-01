package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Direction.*

class PositionTest extends Specification {

    @Unroll
    "should parse positive and negative numbers: #string"() {
        when:
        def position = Position.parse(string)

        then:
        position.getX() == x
        position.getY() == y

        where:
        string  | x  | y
        '0,0'   | 0  | 0
        '2,3'   | 2  | 3
        '-1,-3' | -1 | -3
    }

    @Unroll
    "should throw exception for invalid format: #string"() {
        when:
        Position.parse(string)

        then:
        thrown(RuntimeException)

        where:
        string << [
                'foo',
                'a,b',
                '1,b',
                'a,2',
                '1,2,3'
        ]
    }

    @Unroll
    "should return neighbor in #direction"() {
        given:
        def position = new Position(0, 0)

        expect:
        position.getNeighbor(direction) == neighbor

        where:
        direction | neighbor
        NORTH     | new Position(-1, 0)
        EAST      | new Position(0, 1)
        SOUTH     | new Position(1, 0)
        WEST      | new Position(0, -1)
    }
}
