import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Day2 {

    public static final String FILENAME = "day2Input.txt";

    public static void Part1() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        int twoCount = 0;
        int threeCount = 0;
        String next = "";
        boolean has3 = false;
        boolean has2 = false;
        while((next = br.readLine()) != null){
            int[] letterCounts = new int[26];
            for(int i= 0; i<next.length(); i++){
                letterCounts[next.charAt(i)-97]++;
            }
            for (int i=0; i<letterCounts.length; i++){
                if(has2 && has3){
                    break;
                }
                if(letterCounts[i]==2){
                    has2 = true;
                }
                if(letterCounts[i]==3){
                    has3 = true;
                }
            }

            if(has2){
                twoCount++;
                has2 = false;
            }
            if(has3){
                threeCount++;
                has3 = false;
            }
        }
        System.out.println("Checksum: "+twoCount*threeCount);
    }

    public static void Part2() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        String next = "";
        ArrayList<String> boxIds = new ArrayList<>();
        boolean searching = true;
        while ((next = br.readLine())!=null){
            boxIds.add(next);
        }
        Collections.sort(boxIds);
        for(int i = 0; i<boxIds.size()-1 && searching;i++){
            String currId = boxIds.get(i);
            for(int j = i+1; j<boxIds.size(); j++){
                String otherId = boxIds.get(j);
                boolean has1Difference = false;
                boolean candidate = true;
                String matchingChars = "";
                for(int k = 0; k<currId.length(); k++){
                    if (has1Difference && currId.charAt(k)!= otherId.charAt(k)){
                        candidate = false;
                        break;
                    }
                    if (currId.charAt(k)!=otherId.charAt(k)){
                        has1Difference = true;
                    }
                    else {
                        matchingChars += currId.charAt(k);
                    }
                }
                if (candidate){
                    System.out.println("Solution: "+matchingChars);
                    searching = false;
                    break;
                }
            }
        }
        return;
    }

    public static void main(String[] args) throws Exception {
        Part1();
        Part2();
    }
}
