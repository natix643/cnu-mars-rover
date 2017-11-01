package dk.cngroup.university

import spock.lang.Specification

import static dk.cngroup.university.Direction.*
import static dk.cngroup.university.Field.ACCESSIBLE
import static dk.cngroup.university.Field.INACCESSIBLE

class CameraTest extends Specification {

    def LANDSCAPE = new Landscape([
            [ACCESSIBLE, INACCESSIBLE],
            [ACCESSIBLE, ACCESSIBLE],
    ] as Field[][])

    def "should record only inaccessible fields"() {
        given:
        def position = new Position(0, 0)
        def history = [
                new Rover(position, EAST),
                new Rover(position, SOUTH),
                new Rover(position, WEST),
                new Rover(position, NORTH)
        ]

        when:
        def camera = new Camera()

        for (def rover : history) {
            camera.onAction(rover, LANDSCAPE)
        }

        then:
        Set expected = [new Position(0, 1)]
        camera.getObstacles() == expected
    }

    def "should not record duplicates"() {
        given:
        def position = new Position(0, 0)
        def history = [
                new Rover(position, EAST),
                new Rover(position, SOUTH),
                new Rover(position, EAST)
        ]

        when:
        def camera = new Camera()

        for (def rover : history) {
            camera.onAction(rover, LANDSCAPE)
        }

        then:
        camera.getObstacles() == (Set) [new Position(0, 1)]
    }
}
