package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Input {

    private final Rover initialRover;
    private final Position targetPosition;
    private final Landscape landscape;
    private final List<Action> actions;

    public Input(Rover initialRover, Position targetPosition, Landscape landscape, List<Action> actions) {
        this.initialRover = requireNonNull(initialRover);
        this.targetPosition = requireNonNull(targetPosition);
        this.landscape = requireNonNull(landscape);
        this.actions = requireNonNull(actions);
    }

    public Rover getInitialRover() {
        return initialRover;
    }

    public Landscape getLandscape() {
        return landscape;
    }

    public Position getTargetPosition() {
        return targetPosition;
    }

    public List<Action> getActions() {
        return actions;
    }

    public static Input parse(List<String> lines) {
        return new Input(
                parseInitialRover(lines),
                parseTargetPosition(lines),
                parseLandscape(lines),
                parseActions(lines)
        );
    }

    private static Rover parseInitialRover(List<String> lines) {
        return new Rover(
                Position.parse(lines.get(0)),
                Direction.parse(lines.get(2))
        );
    }

    private static Position parseTargetPosition(List<String> lines) {
        return Position.parse(lines.get(lines.size() - 3));
    }

    private static Landscape parseLandscape(List<String> lines) {
        int size = Integer.parseInt(lines.get(4));
        List<String> landscapeLines = lines.subList(6, 6 + size);
        Field[][] fields = new Field[size][size];

        for (int x = 0; x < size; x++) {
            String[] line = landscapeLines.get(x).split("");
            for (int y = 0; y < size; y++) {
                fields[x][y] = Field.parse(line[y]);
            }
        }
        return new Landscape(fields);
    }

    private static List<Action> parseActions(List<String> lines) {
        List<Action> actions = new ArrayList<>();
        String[] symbols = lines.get(lines.size() - 1).split("");
        for (String symbol : symbols) {
            actions.add(Action.parse(symbol));
        }
        return actions;
    }
}
