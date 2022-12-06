import java.util.*;
import java.io.*;

public class Day6Code1 {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Scanner scanner = null;
        try {
            File file = new File("input.txt");
            scanner = new Scanner(file);
            String array = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                array += line;
            }

            char[] letters = array.toCharArray();
            int marker = 0;
            int len = 14;

            Set<Character> set = new LinkedHashSet<>();
            ArrayList<Character> exam = new ArrayList<>();

            for (int x = 0; x < letters.length; x++) {
                if (marker == 0) {
                    for (int y = x; y < x + len; y++) {
                        exam.add(letters[y]);
                    }

                    set.addAll(exam);
                    exam.clear();

                    if (set.size() == len) {
                        marker = x + len;
                    }
                    set.clear();
                }
            }
            System.out.println(marker);

            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}