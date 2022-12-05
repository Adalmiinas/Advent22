import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;

public class Day5Code1 {
    public static void main(String[] args) {
        System.out.println("Hell");
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
            System.out.println(one);
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

            LinkedList<String> moving = new LinkedList<>();

            String moved = "";

            String[] parts = array.get(0).split(" ");

            int count = 0;
            for (int ind = 10; ind < array.size(); ind++) {
                String[] commands = array.get(ind).split(" ");

                int from = Integer.parseInt(commands[1]);
                for (int x = 0; x < from; x++) {
                    if (commands[3].equals("1")) {
                        moved = moved + one.getLast();
                        one.removeLast();
                    } else if (commands[3].equals("2")) {
                        moved = moved + two.getLast();
                        two.removeLast();
                    } else if (commands[3].equals("3")) {
                        moved = moved + three.getLast();
                        three.removeLast();
                    } else if (commands[3].equals("4")) {
                        moved = moved + four.getLast();
                        four.removeLast();
                    } else if (commands[3].equals("5")) {
                        moved = moved + five.getLast();
                        five.removeLast();
                    } else if (commands[3].equals("6")) {
                        moved = moved + six.getLast();
                        six.removeLast();
                    } else if (commands[3].equals("7")) {
                        moved = moved + seven.getLast();
                        seven.removeLast();
                    } else if (commands[3].equals("8")) {
                        moved = moved + eight.getLast();
                        eight.removeLast();

                    } else {
                        moved = moved + nine.getLast();
                        nine.removeLast();
                    }
                }

                String[] moves = moved.split("");
              
                for (int y = moves.length-1; y >= 0 ; y--) {

                    if (commands[5].equals("1")) {
                        one.addLast(moves[y]);
                    } else if (commands[5].equals("2")) {
                        two.addLast(moves[y]);
                    } else if (commands[5].equals("3")) {
                        three.addLast(moves[y]);
                    } else if (commands[5].equals("4")) {
                        four.addLast(moves[y]);
                    } else if (commands[5].equals("5")) {
                        five.addLast(moves[y]);
                    } else if (commands[5].equals("6")) {
                        six.addLast(moves[y]);
                    } else if (commands[5].equals("7")) {
                        seven.addLast(moves[y]);
                    } else if (commands[5].equals("8")) {
                        eight.addLast(moves[y]);
                    } else {
                        nine.addLast(moves[y]);
                    }
                }
                moved = "";
            }
            System.out.print(one.getLast()+two.getLast()+three.getLast()+four.getLast()+five.getLast()+six.getLast()+seven.getLast()+eight.getLast()+nine.getLast());

            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}
