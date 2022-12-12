import java.util.*;
import java.io.*;

public class Day10Code1 {
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
    
            LinkedList<Integer> values = new LinkedList<>();
            int cycle = 0;
            int currentValue = 1;
            int changingValue = 1;
            int addition = 0;
       
            for (int ind = 0; ind < array.size(); ind++) {
                String [] line = array.get(ind).split(" ");
                System.out.println(line[0]);
                if (line.length >= 2){
                    int amount = Integer.parseInt(line[1]);
                    if (addition == 0){
                        addition += amount;
                        values.add(cycle,changingValue);
                        ind --;
                        cycle++;
                    }
                    else {
                        values.add(cycle,currentValue);
                        changingValue = currentValue + addition;
                        currentValue += addition;
                        addition = 0;
                        cycle ++;
                    }    
                }
                else {
                    values.add(cycle,currentValue);
                    cycle ++;
                }
            }
            System.out.println(values + " " + currentValue + " Cycle " + cycle);
            System.out.println(values.get(19)*20 + values.get(59)*60  + values.get(99)*100 + values.get(139)*140 +values.get(179)*180 +  values.get(219)*220);

            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
