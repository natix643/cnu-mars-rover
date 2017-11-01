package dk.cngroup.university;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            out.println("1st command line argument must be an input file");
            System.exit(1);
        }

        Path file = Paths.get(args[0]);
        List<String> lines = Files.readAllLines(file);
        out.println("Input:\n");
        out.println(String.join("\n", lines));

        Solver solver = new Solver(lines);
        out.println();
        out.println("initial position is valid: " + solver.isInitialPositionValid());
        out.println("target position is valid: " + solver.isTargetPositionValid());

        Position finalPosition = solver.getFinalPosition();
        out.println("final position: " + finalPosition);
        if (finalPosition.equals(solver.getInput().getTargetPosition())) {
            out.println("rover has reached the target: " + true);
        } else {
            out.println("rover has missed the target and ended at: " + finalPosition);
        }

        out.println("obstacles found along the way:");
        for (Position obstacle : solver.getFoundObstacles()) {
            out.println("\t" + obstacle);
        }
    }
}
