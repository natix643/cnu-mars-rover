package dk.cngroup.university

import spock.lang.Specification

class SolverTest extends Specification {

    def "should arrive to target position"() {
        given:
        def solver = new Solver(InputTest.EXAMPLE_LINES)

        expect:
        solver.isInitialPositionValid()
        solver.isTargetPositionValid()
        solver.getFinalPosition() == new Position(4, 0)
        solver.getFoundObstacles() == (Set) [new Position(2, 1)]
    }
}
