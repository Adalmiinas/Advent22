import java.util.*;
import java.io.*;
import java.text.BreakIterator;

public class Day8Code2 {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Scanner scanner = null;
        try {
            File file = new File("input.txt");
            scanner = new Scanner(file);

            ArrayList<String> array = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                array.add(line);
            }
            int rows = array.get(0).length();
            int column = array.size();
            int[][] forest = new int[column][rows];

            for (int x = 0; x < array.size(); x++) {
                String[] numbers = array.get(x).split("");
                for (int y = 0; y < array.get(x).length(); y++) {
                    forest[x][y] = Integer.parseInt(numbers[y]);
                }
            }

            int bestScenic = 0;

            for (int col = 0; col < forest.length; col++) {
                for (int row = 0; row < forest[col].length; row++) {
                    int current = forest[col][row];
                    int scenicDown = 0;
                    int scenicUp = 0;
                    int scenicLeft = 0;
                    int scenicRight = 0;
                    boolean done = false;

                    // down
                    for (int z = col + 1; z < forest.length; z++) {
                        int shift = forest[z][row];
                        if (done == false) {
                            if (shift < current) {
                                scenicDown++;
                            } else if (shift == current) {
                                scenicDown++;
                                done = true;
                            } else {
                                scenicDown++;
                                done = true;
                            }
                        }
                    }
                    // up
                    done = false;
                    for (int z = col - 1; z >= 0; z--) {
                        int shift = forest[z][row];
                        if (done == false) {
                            if (shift < current) {
                                scenicUp++;
                            } else if (shift == current) {
                                scenicUp++;
                                done = true;
                            } else {
                                scenicUp++;
                                done = true;
                            }
                        }
                    }
                    // left
                    done = false;
                    for (int z = row - 1; z >= 0; z--) {
                        int shift = forest[col][z];
                        if (done == false) {
                            if (shift < current) {
                                scenicLeft++;
                            } else if (shift == current) {
                                scenicLeft++;
                                done = true;
                            } else {
                                scenicLeft++;
                                done = true;
                            }
                        }
                    }
                    // right
                    done = false;
                    for (int z = row + 1; z < forest[col].length; z++) {
                        int shift = forest[col][z];
                        if (done == false) {
                            if (shift < current) {
                                scenicRight++;
                            } else if (shift == current) {
                                scenicRight++;
                                done = true;
                            } else {
                                scenicRight++;
                                done = true;
                            }
                        }
                    }
                    int scenicScore = scenicDown * scenicUp * scenicLeft * scenicRight;
                    if (scenicScore > bestScenic) {
                        bestScenic = scenicScore;
                    }
                }
            }
            System.out.print(bestScenic);
            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}
