# PROPOSAL: Mars Rover Simulation

Continue with the "Mars Rover Simulator", the aim is to be able to simulate all the actions that can be taken by the Rover on the Mars:
 - turn right/left
 - move forward/backward

If you like, you can enhance the commands with custom actions - eg. collect sample, take a picture ... use your imagination ;-)

The Simulator takes following inputs:
 - Rover initial position
 - Rover initial direction
 - Landscape _size_ (rectangular)
 - Landscape matrix, with both ACCESSIBLE and INACCESSIBLE fields
 - Rover final position
 - Sequence of Commands for passage through the Landscape

The Simulator output is either TRUE/FALSE, based on the fact, if the Rover reaches its final destination ;-)

## Assumptions
 - we do not expect you to load the data from a file, you can use the TDD approach and simulate the input with a String
 - Coordinates [0, 0] are top-left at the map
 - each information is separated by an empty line
 - both initial and final destination are not at an INACCESSIBLE field
 - you use the TDD approach, we've taught you
 - you ask us, when you need help or support! ;-)
 - yes, we like beer ... :-D

## Example Input with output TRUE

```
1,0

N

5

..0..
.....
.0..0
.0...
.....

2,4

PPFLFPFF
```

The same input with notes:
```
1,0 <- initial position [x, y]
<empty line>
N <- initial direction
<empty line>
5 <- landscape size
<empty line>
..0..
.....
.0..0
.0...
..... <- landscape
<empty line>
2,4 <- final destination
<empty line>
PPFLFPFF <- sequence of commands
```

## Example input with output FALSE

```
1,0

N

5

..0..
.....
.00.0
.....
.....

2,4

PPFLFPFF
```

## Bonus

You can make a little bit more, if you want to :-)

 1. Detect situation, when either initial or final destinations are at an INACCESSIBLE field.
 2. Make a photo every time, when there is a stone (INACCESSIBLE field) right before the Rover, at the end, print _stone coordinates_.
