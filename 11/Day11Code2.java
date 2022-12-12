import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.math.BigInteger;

public class Day11Code2 {
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
            Map<Integer, List<BigInteger>> monkeyItems = new HashMap<Integer, List<BigInteger>>();
            Map<String, String> monkeyStats = new HashMap<String, String>();
            Map<Integer, Integer> monkeyInspect = new HashMap<Integer, Integer>();
            int currentM = -1;
            
            for (int ind = 0; ind < array.size(); ind++){
                String [] line = array.get(ind).split(" ");
                if (line[0].equals("Monkey")){
                    currentM ++;
                    monkeyInspect.put(currentM,0);
                }
                else if (line[0].equals("Starting")){
                    ArrayList<BigInteger> list = new ArrayList<>();
                    for (int x = 2; x < line.length; x++){
                        String [] y = line[x].split(""); 
                        int number = Integer.parseInt(y[0] + y[1]);
                        list.add(BigInteger.valueOf(number));
                    }
                    monkeyItems.put(currentM,list);
                }
                else if (line[0].equals("Operation:")){
                    String y = line[4] + " "  + line[5];
                    monkeyStats.put(currentM+" OP", y);
                }
                else if (line[0].equals("Test:")){
                    monkeyStats.put(currentM+ " Test", line[3]);
                }
                else if (line[0].equals("If")){
                    if (line[1].equals("true:")) {
                        monkeyStats.put(currentM+ " true", line[5]);
                    }
                    else {
                        monkeyStats.put(currentM+ " false", line[5]);
                    }
                }
            }

            LinkedList<LinkedList<BigInteger>> newMonkeyItems = new LinkedList<>();
    
            for (int cycle = 0; cycle < 10000; cycle++){
                newMonkeyItems.clear();
                for (int x = 0; x < monkeyItems.size(); x++){
                    newMonkeyItems.add(x, new LinkedList<BigInteger>());
        
                    for (int y= 0; y < monkeyItems.get(x).size(); y++){
                        newMonkeyItems.get(x).add(monkeyItems.get(x).get(y));
                    }
                }
                monkeyItems.clear();
                monkeyItems.put(0, new LinkedList<BigInteger>());
                monkeyItems.put(1, new LinkedList<BigInteger>());
                monkeyItems.put(2, new LinkedList<BigInteger>());
                monkeyItems.put(3, new LinkedList<BigInteger>());
                monkeyItems.put(4, new LinkedList<BigInteger>());
                monkeyItems.put(5, new LinkedList<BigInteger>());
                monkeyItems.put(6, new LinkedList<BigInteger>());
                monkeyItems.put(7, new LinkedList<BigInteger>());
                for (int x = 0; x < newMonkeyItems.size(); x++){
                    for (int y= 0; y < newMonkeyItems.get(x).size(); y++){
                        BigInteger value =  newMonkeyItems.get(x).get(y);
                        monkeyInspect.put(x, monkeyInspect.get(x)+1);
                        String [] operation = monkeyStats.get(x+ " OP").split(" ");
                        BigInteger add;
                        if (operation[1].equals("old")){
                            add = value;
                        }
                        else {
                            add = BigInteger.valueOf(Integer.parseInt(operation[1]));
                        }
                       
                        if (operation[0].equals("*")){
                            value= value.multiply(add);
                        }
                        else {
                            value = value.add(add);
                        }
                        
                        BigInteger div = new BigInteger("9699690");
                        value = value.mod(div);
                        BigInteger division = BigInteger.valueOf(Integer.parseInt(monkeyStats.get(x+ " Test")));

                        if (value.mod(division).equals(BigInteger.ZERO)){
                            int monkey = Integer.parseInt(monkeyStats.get(x+ " true"));
                
                            if (monkey > x){
                                newMonkeyItems.get(monkey).add(value);
                            }
                            else {
                                monkeyItems.get(monkey).add(value);
                            }
                        }
                        else {
                            int monkey = Integer.parseInt(monkeyStats.get(x+ " false"));
                            if (monkey > x){
                                newMonkeyItems.get(monkey).add(value);
                            }
                            else {
                                monkeyItems.get(monkey).add(value);
                            }
                        }
                    }
                }
            }

            int highest = 0;
            int second = 0;
            for (int z = 0; z < monkeyInspect.size(); z++){
                if (monkeyInspect.get(z) > second){
                    second = monkeyInspect.get(z);
                    if (monkeyInspect.get(z) > highest){
                        second = highest;
                        highest = monkeyInspect.get(z);
                    }
                }
            }
            System.out.println(BigInteger.valueOf(highest).multiply(BigInteger.valueOf(second)));
        
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
