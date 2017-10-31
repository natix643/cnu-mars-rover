package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Action.*
import static dk.cngroup.university.Direction.*

class ActionTest extends Specification {

    @Unroll
    "should parse '#symbol' to #action"() {
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

    @Unroll
    "LEFT should change direction from #oldDirection to #newDirection"() {
        given:
        def position = new Position(0, 0)
        def oldRover = new Rover(position, oldDirection)

        def landscape = Mock(Landscape)

        when:
        def newRover = LEFT.updateRover(oldRover, landscape)

        then:
        newRover.getPosition() == position
        newRover.getDirection() == newDirection

        where:
        oldDirection | newDirection
        NORTH        | WEST
        EAST         | NORTH
        SOUTH        | EAST
        WEST         | SOUTH
    }


    @Unroll
    "RIGHT should change direction from #oldDirection to #newDirection"() {
        given:
        def position = new Position(0, 0)
        def oldRover = new Rover(position, oldDirection)

        def landscape = Mock(Landscape)

        when:
        def newRover = RIGHT.updateRover(oldRover, landscape)

        then:
        newRover.getPosition() == position
        newRover.getDirection() == newDirection

        where:
        oldDirection | newDirection
        NORTH        | EAST
        EAST         | SOUTH
        SOUTH        | WEST
        WEST         | NORTH
    }
}
