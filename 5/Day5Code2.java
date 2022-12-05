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

            LinkedList<String> one = new LinkedList<>();
            one.add("Z");
            one.add("P");
            one.add("M");
            one.add("H");
            one.add("R");
            LinkedList<String> two = new LinkedList<>();
            two.add("P");
            two.add("C");
            two.add("J");
            two.add("B");
            LinkedList<String> three = new LinkedList<>();
            three.add("S");
            three.add("N");
            three.add("H");
            three.add("G");
            three.add("L");
            three.add("C");
            three.add("D");
            LinkedList<String> four = new LinkedList<>();
            four.add("F");
            four.add("T");
            four.add("M");
            four.add("D");
            four.add("Q");
            four.add("S");
            four.add("R");
            four.add("L");
            LinkedList<String> five = new LinkedList<>();
            five.add("F");
            five.add("S");
            five.add("P");
            five.add("Q");
            five.add("B");
            five.add("T");
            five.add("Z");
            five.add("M");
            LinkedList<String> six = new LinkedList<>();
            six.add("T");
            six.add("F");
            six.add("S");
            six.add("Z");
            six.add("B");
            six.add("G");
            LinkedList<String> seven = new LinkedList<>();
            seven.add("N");
            seven.add("R");
            seven.add("V");
            LinkedList<String> eight = new LinkedList<>();
            eight.add("P");
            eight.add("Q");
            eight.add("L");
            eight.add("T");
            eight.add("D");
            eight.add("V");
            eight.add("C");
            eight.add("M");
            LinkedList<String> nine = new LinkedList<>();
            nine.add("W");
            nine.add("Q");
            nine.add("N");
            nine.add("J");
            nine.add("F");
            nine.add("M");
            nine.add("L");

            LinkedList<LinkedList<String>> wholeList = new LinkedList<>();
            wholeList.add(one);
            wholeList.add(two);
            wholeList.add(three);
            wholeList.add(four);
            wholeList.add(five);
            wholeList.add(six);
            wholeList.add(seven);
            wholeList.add(eight);
            wholeList.add(nine);

            String moved = "";

            for (int ind = 10; ind < array.size(); ind++) {
                String[] commands = array.get(ind).split(" ");
                int amount = Integer.parseInt(commands[1]);
                int from = Integer.parseInt(commands[3])-1;
                
                for (int x = 0; x < amount; x++) {
                    moved = moved + wholeList.get(from).getLast();
                    wholeList.get(from).removeLast();
                }

                String[] moves = moved.split("");

                for (int y = moves.length-1; y >= 0 ; y--) {

                    int to = Integer.parseInt(commands[5])-1;
                    wholeList.get(to).addLast(moves[y]);
                }

                moved = "";
            }

            System.out.print(one.getLast()+two.getLast()+three.getLast()+four.getLast()+five.getLast()+six.getLast()+seven.getLast()+eight.getLast()+nine.getLast());

            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}
