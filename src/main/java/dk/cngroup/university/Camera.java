package dk.cngroup.university;

import java.util.LinkedHashSet;
import java.util.Set;

import static dk.cngroup.university.Field.INACCESSIBLE;

/**
 * After each action, if the rover is facing an inaccessible field, the field's position is recorded (no duplicates).
 */
public class Camera {

    private Set<Position> obstacles = new LinkedHashSet<>();

    public void onAction(Rover afterAction, Landscape landscape) {
        Position lookingAt = afterAction.getPosition().getNeighbor(afterAction.getDirection());
        if (landscape.getField(lookingAt) == INACCESSIBLE) {
            obstacles.add(lookingAt);
        }
    }

    public Set<Position> getObstacles() {
        return obstacles;
    }
}
