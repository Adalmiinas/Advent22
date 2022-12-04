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
        
            int count = 0;
            for (int ind = 0; ind < array.size(); ind++) {
        
                String[] parts = array.get(ind).split(",");
                String[] firstElf = parts[0].split("-");
                String[] secondElf = parts[1].split("-");

                int e1n1 = Integer.parseInt(firstElf[0]);
                int e1n2 = Integer.parseInt(firstElf[1]);
                int e2n1 = Integer.parseInt(secondElf[0]);
                int e2n2 = Integer.parseInt(secondElf[1]);

                if ((e1n1 <= e2n1 && e1n2 >= e2n2) || (e1n1 >= e2n1 && e1n2 <= e2n2)){
                    count ++;
                }
            }
            System.out.println(count);

            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}
