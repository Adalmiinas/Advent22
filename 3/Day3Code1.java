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
            //String [] alphabets = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
            String  alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

            String letters = ""; 


            for (int ind = 0; ind < array.size(); ind++) {
        
                int len = array.get(ind).length();
                //System.out.println(len);

                String[] parts = {array.get(ind).substring(0, len/2),array.get(ind).substring(len/2)};
                //System.out.println(parts[1]);

                char[] items = parts[0].toCharArray();  
                char[] comparable = parts[1].toCharArray();  

                // System.out.println(items[0]);
                boolean done = false; 

                for (int x = 0; x < items.length; x++) {
                    if (done == false) {
                        for (int y = 0; y < comparable.length; y++) {
                            if (done == false && items[x] == comparable[y] && Character.isUpperCase(items[x]) == Character.isUpperCase(comparable[y])){
                                // System.out.println(items[x]);
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
                //System.out.println(alphabets.indexOf(chars[z]));

                points += alphabets.indexOf(chars[z]) + 1;
            }
            System.out.println(points);

            scanner.close();

        } catch (FileNotFoundException e) {
        }
    }
}
