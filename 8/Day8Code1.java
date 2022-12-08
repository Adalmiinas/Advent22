import java.util.*;
import java.io.*;

public class Day8Code1 {
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
            int [][] forest = new int [column][rows];
 
            for (int x = 0; x < array.size(); x++) {
                String [] numbers = array.get(x).split("");
                for (int y = 0; y < array.get(x).length(); y++) {
                    forest[x][y] =  Integer.parseInt(numbers[y]);
                }
            }
        
            int seen = 0;

            for (int col = 0; col< forest.length; col++) {
                for (int row = 0; row < forest[col].length; row++) {
                    int current = forest[col][row];
                    if (col == 0 ||row == 0 || col == forest.length -1 || row == forest[col].length -1){
                       seen++;
                    }
                    else {
                        int maxDown = 0; 
                        int maxUp = 0; 
                        int maxLeft = 0; 
                        int maxRight = 0; 
                        //down
                        for(int z = col+1; z < forest.length; z++) {
                            int shift = forest[z][row];
                            if(shift > maxDown){
                                maxDown = shift;
                            }
                        }
                        //up
                        for(int z = col-1; z >= 0; z--) {
                            int shift = forest[z][row];
                            if(shift > maxUp){
                                maxUp = shift;
                            }
                        }
                        // left
                        for(int z = row-1; z >=  0; z--) {
                            int shift = forest[col][z];
                            if(shift > maxLeft){
                                maxLeft = shift;
                            }
                        }
                        //right
                        for(int z = row+1; z < forest[col].length; z++) {
                            int shift = forest[col][z];
                            if(shift > maxRight){
                                maxRight = shift;
                            }
                        }
        
                        if (current > maxDown || current > maxUp ||current > maxRight ||current > maxLeft){
                            seen++;
                        }
                    } 
                }
            }

            System.out.print(seen);
            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}
