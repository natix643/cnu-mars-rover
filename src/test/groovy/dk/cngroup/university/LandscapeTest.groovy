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

    def "should generate fields"() {
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
    "should return field for (#position)"() {
        given:
        def landscape = new Landscape([[ACCESSIBLE, INACCESSIBLE]] as Field[][])

        expect:
        landscape.getField(position) == field

        where:
        position           | field
        new Position(0, 0) | ACCESSIBLE
        new Position(0, 1) | INACCESSIBLE
        new Position(0, 2) | null
    }
}
