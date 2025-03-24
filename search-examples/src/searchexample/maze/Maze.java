package searchexample.maze;

/* Finding the solution out of a maze.
   Illustrates searching using stacks (depth-first search) and queues (breadth-first search).
*/

// DFS
// a b c d
// e f g b c d
// h i f g b c d
//...

// BFS
// a b c d
// b c d e f g
// c d e f g x y z
// ...

/*
         root
        /    \   ....
       /      \
      a        b
     /|\
    / | \
    e f  g
 */

import java.util.Stack;
import java.util.LinkedList;

public class Maze {
    final static char C = ' ', X = 'x', S = 's', E = 'e', V = '.';

    final static int START_I = 1, START_J = 1;
    final static int END_I = 2, END_J = 9;
    private static final char[][] maze = {
            {X, X, X, X, X, X, X, X, X, X},
            {X, S, C, C, C, C, C, C, C, X},
            {X, C, C, C, X, C, X, X, C, E},
            {X, C, X, X, X, C, X, X, C, X},
            {X, C, C, C, C, X, X, X, C, X},
            {X, X, X, X, C, X, X, X, C, X},
            {X, X, X, X, C, X, C, C, C, X},
            {X, X, C, X, C, X, X, C, C, X},
            {X, X, C, C, C, C, C, C, C, X},
            {X, X, X, X, X, X, C, X, X, X}
    };

    public static void main(String[] args) {

        Maze maze = new Maze();
        maze.print();

        System.out.println("\n\nFind a path using a stack: ");
        maze.solveStack();
//
//        System.out.println("\n\nFind a path using a queue: ");
//        maze.solveQueue();

//     System.out.println("\n\nFind a path recursively: ");
//     maze.solveRec();

    }

    public int size() {
        return maze.length;
    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                System.out.print(maze[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public char mark(int i, int j, char value) {
        assert (isInMaze(i, j));
        char tmp = maze[i][j];
        maze[i][j] = value;
        return tmp;
    }

    public char mark(MazePos pos, char value) {
        return mark(pos.i(), pos.j(), value);
    }

    public boolean isMarked(int i, int j) {
        assert (isInMaze(i, j));
        return (maze[i][j] == V);
    }

    public boolean isMarked(MazePos pos) {
        return isMarked(pos.i(), pos.j());
    }

    public boolean isClear(int i, int j) {
        assert (isInMaze(i, j));
        return (maze[i][j] != X && maze[i][j] != V);
    }

    public boolean isClear(MazePos pos) {
        return isClear(pos.i(), pos.j());
    }

    //true if cell is within maze
    public boolean isInMaze(int i, int j) {
        return i >= 0 && i < size() && j >= 0 && j < size();
    }

    //true if cell is within maze
    public boolean isInMaze(MazePos pos) {
        return isInMaze(pos.i(), pos.j());
    }

    public boolean isFinal(int i, int j) {
        return (i == Maze.END_I && j == Maze.END_J);
    }

    public boolean isFinal(MazePos pos) {
        return isFinal(pos.i(), pos.j());
    }

    public char[][] copy() {
        char[][] mazeCopy = new char[size()][size()];
        for (int i = 0; i < size(); i++)
            for (int j = 0; j < size(); j++)
                mazeCopy[i][j] = maze[i][j];
        return mazeCopy;
    }

    public void restore(char[][] savedMaze) {
        for (int i = 0; i < size(); i++)
            for (int j = 0; j < size(); j++)
                maze[i][j] = savedMaze[i][j];
    }


    // THE GOAL IS TO FIND A PATH FROM START TO END

    // *************************************************
    // This solution uses a stack to keep track of possible states/positions to explore;
    // it marks the maze to remember the positions that it's already explored.
    public void solveStack() {

        //save the maze
        char[][] savedMaze = copy();

        //declare the locations stack
        Stack<MazePos> candidates = new Stack<>();

        //insert the start
        candidates.push(new MazePos(START_I, START_J));

        MazePos current, next;
        while (!candidates.empty()) {

            //get current position
            current = candidates.pop();

            if (isFinal(current)) break;

            //mark the current position
            mark(current, V);

            //put its neighbors onto the stack
            next = current.north();
            if (isInMaze(next) && isClear(next) && !isMarked(next)) candidates.push(next);
            next = current.west();
            if (isInMaze(next) && isClear(next) && !isMarked(next)) candidates.push(next);
            next = current.east();
            if (isInMaze(next) && isClear(next) && !isMarked(next)) candidates.push(next);
            next = current.south();
            if (isInMaze(next) && isClear(next) && !isMarked(next)) candidates.push(next);
        }

        System.out.println(!candidates.empty() ? "Found a solution: " : "You're stuck in the maze!");
        print();

        //restore the maze
        restore(savedMaze);
    }


    //**************************************************
    //this solution uses a QUEUE to keep track of possible
    //states/positions to explore; it marks the maze to remember the
    //positions that it's already explored.
    public void solveQueue() {

        //save the maze
        char[][] savedMaze = copy();

        //declare the locations stack
        var candidates = new LinkedList<MazePos>();

        //insert the start
        candidates.add(new MazePos(START_I, START_J));

        MazePos current, next;
        while (!candidates.isEmpty()) {

            //get current position
            current = candidates.removeFirst();

            if (isFinal(current)) break;

            //mark the current position
            mark(current, V);

            //put its neighbors in the queue
            next = current.north();
            if (isInMaze(next) && isClear(next)) candidates.add(next);
            next = current.east();
            if (isInMaze(next) && isClear(next)) candidates.add(next);
            next = current.west();
            if (isInMaze(next) && isClear(next)) candidates.add(next);
            next = current.south();
            if (isInMaze(next) && isClear(next)) candidates.add(next);
        }

        System.out.println(!candidates.isEmpty() ? "Found a solution: " : "You're stuck in the maze!");
        print();

        //restore the maze
        restore(savedMaze);
    }


    //**************************************************
    // solve using recursion.
    //
    // Note: this solution unmarks the path upon reaching
    // dead ends, so in the end only the path is left marked.
    // It is possible to write a solution that does not un-mark its traces,
    // but instead it clones and restores the maze.

    public void solveRec() {

        if (solve(new MazePos(START_I, START_J))) {
            System.out.println("Found a solution: ");
        } else {
            System.out.println("You're stuck in the maze.");
        }
        print();
    }


    // Find a path to exit the maze from this position.
    // Works recursively, by advancing to a neighbor and continuing from there.
    // If a path is found, return true. Otherwise return false.

    public boolean solve(MazePos position) {

        //base case
        if (!isInMaze(position)) return false;
        if (isFinal(position)) return true;
        if (!isClear(position)) return false;

        // recurse

        // first mark this  location
        mark(position, V);

        System.out.println("Trying south from position: " + position);

        // try to go south
        if (solve(position.south())) {
            // We have found a solution going south:
            // if we want to leave the maze clean, then unmark current cell and return;
            // if we want to mark the path in the maze, then don't unmark
            // mark(pos, C);
            return true;
        }
        System.out.println("Trying west from position: " + position);

        //else west
        if (solve(position.west())) {
            // We have found a solution going west:
            // if we want to leave the maze clean, then unmark current cell and return;
            // if we want to mark the path in the maze, then don't unmark
            // mark(pos, C);
            return true;
        }

        System.out.println("Trying north from position: " + position);

        //else north
        if (solve(position.north())) {
            // We have found a solution going north:
            // if we want to leave the maze clean, then unmark current cell and return;
            // if we want to mark the path in the maze, then don't unmark
            // mark(pos, C);
            return true;
        }

        System.out.println("Trying east from position: " + position);

        //else east
        if (solve(position.east())) {
            // We have found a solution going east:
            // if we want to leave the maze clean, then unmark current cell and return;
            // if we want to mark the path in the maze, then don't unmark
            // mark(pos, C);
            return true;
        }

        //unmark all dead ends; since it was marked, the position must have been clear
        mark(position, C);

        //if none of the above returned, then there is no solution
        return false;
    }

    private record MazePos(int i, int j) {
        @Override
        public String toString() {
            return "(" + i + "," + j + ")";
        }

        public MazePos north() {
            return new MazePos(i - 1, j);
        }

        public MazePos south() {
            return new MazePos(i + 1, j);
        }

        public MazePos east() {
            return new MazePos(i, j + 1);
        }

        public MazePos west() {
            return new MazePos(i, j - 1);
        }
    }
}