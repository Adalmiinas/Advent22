import java.util.*;
import java.io.*;

public class Day9Code1 {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Scanner scanner = null;
        try {
            File file = new File("input.txt");
            scanner = new Scanner(file);

            ArrayList<String> array = new ArrayList<>();
            Map<String, List<Integer>> move = new HashMap<String, List<Integer>>();
            move.put("U", new ArrayList<Integer>(Arrays.asList(0, 1)));
            move.put("D", new ArrayList<Integer>(Arrays.asList(0, -1)));
            move.put("L", new ArrayList<Integer>(Arrays.asList(-1, 0)));
            move.put("R", new ArrayList<Integer>(Arrays.asList(1, 0)));
           
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                array.add(line);
            }
    
            int headX = 0;
            int headY = 0;
            int tailX = 0;
            int tailY = 0;
            HashSet<List<Integer>> visit = new HashSet<>();
            visit.add(List.of(0, 0));

            for (int ind = 0; ind < array.size(); ind++) {
                String [] line = array.get(ind).split(" ");
                String direc = line[0];
                int step = Integer.parseInt(line[1]);

                for (int y = 0; y < step; y++) {
                    headX = headX + move.get(direc).get(0);    
                    headY = headY + move.get(direc).get(1);  

                    int capX = headX - tailX;
                    int capY = headY - tailY;
        

                    if ((Math.abs(capX) >= 2) || (Math.abs(capY) >= 2)){
                        tailX = tailX + Math.round(Math.signum(capX));
                        tailY = tailY + Math.round(Math.signum(capY)); 
                    }
                    visit.add(List.of(tailX, tailY));
                }
            }

            System.out.print(visit.size());
            scanner.close();

        } catch (FileNotFoundException e) {

        }
    }
}
