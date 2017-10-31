package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Direction.NORTH

class RoverTest extends Specification {

    def "should return given position and direction"() {
        given:
        def position = new Position(1, 2)
        def direction = NORTH

        when:
        def rover = new Rover(position, direction)

        then:
        rover.getDirection() == direction
        rover.getPosition() == position
    }

    @Unroll
    "should reject null #nullProperty"() {
        when:
        new Rover(position, direction)

        then:
        thrown(NullPointerException)

        where:
        nullProperty | position           | direction
        'position'   | null               | NORTH
        'direction'  | new Position(0, 0) | null
    }
}
