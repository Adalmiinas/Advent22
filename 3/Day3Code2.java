import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Day3Code1 {
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

            String  alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String letters = ""; 

            for (int ind = 0; ind < array.size(); ind = ind + 3) {
        
                int len = array.get(ind).length();

                String[] parts = {array.get(ind),array.get(ind+1), array.get(ind+2)};

                String[] items = parts[0].split("");  
                char[] comparable = parts[1].toCharArray();  

                boolean done = false; 

                for (int x = 0; x < items.length; x++) {
                    if (done == false && parts[1].contains(items[x]) && parts[2].contains(items[x])){
                        letters += items[x];
                        done = true;
                    }
                }
            }
      
            String[] chars = letters.split("");  
            int points = 0;
            
            for (int z = 0; z < chars.length; z++) {
                points += alphabets.indexOf(chars[z]) + 1;
            }
            System.out.println(points);

            scanner.close();

        } catch (FileNotFoundException e) {
        }
    }
}
