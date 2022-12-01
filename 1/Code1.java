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
            int calories = 0; 

            for (int ind = 0; ind < array.size(); ind++) {
                if (array.get(ind).length() != 0) {
                        calories += Integer.valueOf(array.get(ind));
                        //System.out.println(calories);
                } else {
                    if(calories > largest) {
                        largest = calories;
                    }
                    calories = 0;
                }
            }

            System.out.print(largest);

            scanner.close();
        } catch (FileNotFoundException e) {
            if (scanner != null) {
                scanner.close();
            }

        }
    }
}