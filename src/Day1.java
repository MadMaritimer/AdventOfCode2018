import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    public static final String FILENAME = "puzzleInput.txt";

    public static void main(String[] args) throws Exception {
        List<Integer> usedFrequencies = new ArrayList<>();
        int freq = 0;
        usedFrequencies.add(freq);
        int count = 0;
        while(true){
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String change = "";
            while ((change = br.readLine()) != null){
                int changeInt = Integer.parseInt(change.substring(1));
                if(change.charAt(0)=='+'){
                    freq += changeInt;
                }
                else{
                    freq -= changeInt;
                }
                if(usedFrequencies.contains(freq)){
                    System.out.println("Final Answer: "+ freq);
                    System.exit(0);
                }
                usedFrequencies.add(freq);
            }
            System.out.println("Runs: "+ ++count);
            //System.out.println("Final answer: "+freq);
        }
    }
}
