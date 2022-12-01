import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Code1 {
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

            int largest = 0; 
            int largest2 = 0;
            int largest3 = 0;
            int calories = 0; 

            for (int ind = 0; ind < array.size(); ind++) {
                if (array.get(ind).length() != 0) {
                        calories += Integer.valueOf(array.get(ind));
                        
                } else {
                    if(calories > largest) {
                        largest3 = largest2; 
                        largest2 = largest;
                        largest = calories;
                    }
                    calories = 0;
                }
            }
   
            System.out.print(largest+largest2+largest3);

            scanner.close();
        } catch (FileNotFoundException e) {
            if (scanner != null) {
                scanner.close();
            }

        }
    }
}