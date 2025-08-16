package DP;

import java.util.ArrayList;

public class getMazePathWithDiagonals {
    public static void main(String[] args) {
        System.out.println(getAllpaths(1, 1, 3, 3));
    }

    // Find all paths from (sr, sc) to (dr, dc) allowing vertical, horizontal, and diagonal moves.
    public static ArrayList<String> getAllpaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add(""); // empty path at destination
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();

        // Move vertically down
        if (sr < dr) {
            ArrayList<String> down = getAllpaths(sr + 1, sc, dr, dc);
            for (String path : down) {
                paths.add("V" + path);
            }
        }

        // Move horizontally right
        if (sc < dc) {
            ArrayList<String> right = getAllpaths(sr, sc + 1, dr, dc);
            for (String path : right) {
                paths.add("H" + path);
            }
        }

        // Move diagonally (down-right)
        if (sr < dr && sc < dc) {
            ArrayList<String> diagonal = getAllpaths(sr + 1, sc + 1, dr, dc);
            for (String path : diagonal) {
                paths.add("D" + path);
            }
        }

        return paths;
    }
}
