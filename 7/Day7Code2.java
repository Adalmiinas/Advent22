import java.util.*;
import java.io.*;

public class Day7Code1 {
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

            LinkedList<String> location = new LinkedList<>();
            HashMap<String, Integer> folders = new HashMap<String, Integer>();

            for (int ind = 0; ind < array.size(); ind++) {
                String[] commands = array.get(ind).split(" ");
                if (commands[1].equals("cd")) {
                    if (!commands[2].equals("..")) {
                        if (location.size() == 0){
                            location.add(commands[2]);
                        }
                        else {
                            location.add(location.getLast() + commands[2]);
                        }
                    } else if (commands[2].equals("..")) {
                        location.removeLast();
                    }
                } else if (!commands[0].equals("$") && !commands[0].equals("dir")) {

                    int addition = Integer.parseInt(commands[0]);
                    for (int x = 0; x < location.size(); x++) {
                        try {
                            int value = folders.get(location.get(x)) + addition;
                            folders.replace(location.get(x), value);

                        } catch (Exception e) {
                            folders.put(location.get(x), addition);
                        }
                    }
                }
            }
            int space = 70000000 - folders.get("/");
            int needed = 30000000 - space;
            int current = space;

            for (Integer i : folders.values()) {
                if (i >= needed) {
                    if (i <= current){
                        current = i;
                    }
                }
            }
            System.out.print(current);
            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}