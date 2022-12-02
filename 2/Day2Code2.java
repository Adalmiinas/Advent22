import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Day2Code1 {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Scanner scanner = null;
        try {
            File file = new File("input1.txt");
            scanner = new Scanner(file);

            ArrayList<String> array = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                array.add(line);
            }

            int points = 0; 

            for (int ind = 0; ind < array.size(); ind++) {
                if (array.get(ind).contains("A")) {
                    if(array.get(ind).contains("X")){
                        points += 3 + 0; 
                    }
                    else if(array.get(ind).contains("Y")){
                        points += 1 + 3; 
                    }
                    else {
                        points += 2 + 6; 
                    }
                }
                else if (array.get(ind).contains("B")){
                    if(array.get(ind).contains("X")){
                        points += 1 + 0; 
                    }
                    else if(array.get(ind).contains("Y")){
                        points += 2 + 3; 
                    }
                    else {
                        points += 3 + 6; 
                    }
                        
                } else {
                    if(array.get(ind).contains("X")){
                        points += 2 + 0; 
                    }
                    else if(array.get(ind).contains("Y")){
                        points += 3 + 3; 
                    }
                    else {
                        points += 1 + 6; 
                    }
                }
            }
   
            System.out.println(points);

            scanner.close();
        } catch (FileNotFoundException e) {
            if (scanner != null) {
                scanner.close();
            }

        }
    }
}