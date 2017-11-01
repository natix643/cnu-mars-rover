package dk.cngroup.university

import spock.lang.Specification

import static dk.cngroup.university.Action.*
import static dk.cngroup.university.Direction.NORTH
import static dk.cngroup.university.Field.ACCESSIBLE
import static dk.cngroup.university.Field.INACCESSIBLE

class InputTest extends Specification {

    static EXAMPLE_LINES = [
            '1,0',
            '',
            'N',
            '',
            '5',
            '',
            '..0..',
            '.....',
            '.0..0',
            '.0...',
            '.....',
            '',
            '4,0',
            '',
            'RRFLFRFF'
    ]

    def "should parse lines"() {
        when:
        def input = Input.parse(EXAMPLE_LINES)

        then:
        input.initialRover == new Rover(new Position(1, 0), NORTH)
        input.targetPosition == new Position(4, 0)
        input.actions == [RIGHT, RIGHT, FORWARD, LEFT, FORWARD, RIGHT, FORWARD, FORWARD]

        input.landscape == new Landscape([
                [ACCESSIBLE, ACCESSIBLE, INACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
                [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
                [ACCESSIBLE, INACCESSIBLE, ACCESSIBLE, ACCESSIBLE, INACCESSIBLE],
                [ACCESSIBLE, INACCESSIBLE, ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
                [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
        ] as Field[][])
    }
}
