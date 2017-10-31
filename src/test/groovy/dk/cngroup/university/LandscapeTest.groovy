package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Field.ACCESSIBLE
import static dk.cngroup.university.Field.INACCESSIBLE

class LandscapeTest extends Specification {

    static Field[][] ALL_ACCESSIBLE_FIELDS = [
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE]
    ]

    def "should generate landscape"() {
        given:
        def generator = Mock(FieldGenerator)
        9 * generator.getRandomField() >> ACCESSIBLE

        when:
        def landscape = new Landscape(generator, 3)

        then:
        landscape.getFields() == ALL_ACCESSIBLE_FIELDS
    }

    def "should print to string"() {
        given:
        def generator = Mock(FieldGenerator)
        generator.getRandomField() >>> [INACCESSIBLE, INACCESSIBLE, ACCESSIBLE]

        def landscape = new Landscape(generator, 3)

        when:
        String result = landscape.toString()

        then:
        result == """
            |00.
            |...
            |...
        """.stripMargin('|').trim() // removes first and last line breaks and everything to left of '|'
    }

    @Unroll
    "should return #isAccessible for #x:#y"(boolean isAccessible, int x, int y) {
        given:
        FieldGenerator generator = Mock(FieldGenerator)
        generator.getRandomField() >>> [INACCESSIBLE, INACCESSIBLE, ACCESSIBLE]

        Landscape landscape = new Landscape(generator, 3)

        def position = new Position(x, y)

        expect:
        isAccessible == landscape.isFieldAccessible(position)

        where:
        isAccessible | x  | y
        false        | 0  | 0
        false        | 0  | 1
        true         | 0  | 2
        true         | 1  | 0
        false        | 3  | 3
        false        | -1 | -2
    }

}
