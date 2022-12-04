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


            for (int ind = 0; ind < array.size(); ind++) {
        
                int len = array.get(ind).length();

                String[] parts = {array.get(ind).substring(0, len/2),array.get(ind).substring(len/2)};

                char[] items = parts[0].toCharArray();  
                char[] comparable = parts[1].toCharArray();  

                boolean done = false; 

                for (int x = 0; x < items.length; x++) {
                    if (done == false) {
                        for (int y = 0; y < comparable.length; y++) {
                            if (done == false && items[x] == comparable[y] && Character.isUpperCase(items[x]) == Character.isUpperCase(comparable[y])){
                                letters += items[x];
                                done = true;
                            }
                        }
                    }
                }
            }
            System.out.println(letters);
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
