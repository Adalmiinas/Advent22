import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;

public class Day5Code1 {
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

            LinkedList<LinkedList<String>> wholeList = new LinkedList<>();
            int length = array.get(0).length() / 4 + 1;

            for (int y = 0; y < length; y++) {
                wholeList.add(new LinkedList<String>());
            }

            for (int ind = 0; ind < 8; ind++) {
                char[] line = array.get(ind).toCharArray();
                for (int x = 0; x < line.length; x++) {
                    String c = Character.toString(line[x]);
                    if (Character.isLetter(line[x])) {
                        int position = x / 4;
                        wholeList.get(position).addFirst(c);
                    }
                }
            }

            for (int ind = 10; ind < array.size(); ind++) {
                String[] commands = array.get(ind).split(" ");
                int amount = Integer.parseInt(commands[1]);
                int from = Integer.parseInt(commands[3]) - 1;
                int to = Integer.parseInt(commands[5]) - 1;

                for (int x = 0; x < amount; x++) {
                    String move = wholeList.get(from).getLast();
                    wholeList.get(to).addLast(move);
                    wholeList.get(from).removeLast();
                }
            }

            System.out.print(wholeList.get(0).getLast() + wholeList.get(1).getLast() + wholeList.get(2).getLast()
                    + wholeList.get(3).getLast() + wholeList.get(4).getLast() + wholeList.get(5).getLast()
                    + wholeList.get(6).getLast() + wholeList.get(7).getLast() + wholeList.get(8).getLast());

            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}
