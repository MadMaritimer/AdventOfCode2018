import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day3 {

    public static final String FILENAME = "day3Input.txt";

    public static Map<Integer, Map<Integer,Boolean>> Part1() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        String next = "";
        int count = 0;
        Map<Integer, Map<Integer, Boolean>> usageMap = new HashMap<>();

        while((next = br.readLine()) != null){
            String[] tokens = next.split("\\s+");
            String[] topCornerCoords = tokens[2].split(",");
            Integer cornerX = Integer.parseInt(topCornerCoords[0]);
            Integer cornerY = Integer.parseInt(topCornerCoords[1].substring(0, topCornerCoords[1].length()-1));
            int spanX = Integer.parseInt(tokens[3].split("x")[0]);
            int spanY = Integer.parseInt(tokens[3].split("x")[1]);
            System.out.println();
            for (int x = cornerX; x < cornerX + spanX; x++){
                if(!usageMap.containsKey(x)){
                    usageMap.put(x, new HashMap<>());
                }
                for(int y = cornerY; y < cornerY + spanY; y++){
                    Map<Integer, Boolean> column = usageMap.get(x);
                    if(!column.containsKey(y)){
                        column.put(y, false);
                        continue;
                    }
                    if(!column.get(y).booleanValue()){
                        column.put(y, true);
                        count++;
                    }

                }
            }
        }
        System.out.println("Part 1 Answer: " + count);
        return usageMap;
    }

    public static int Part2(Map<Integer,Map<Integer, Boolean>> usageMap)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        String next = "";

        while((next = br.readLine()) != null){
            String[] tokens = next.split("\\s+");
            String[] topCornerCoords = tokens[2].split(",");
            int patchId = Integer.parseInt(tokens[0].substring(1));
            Integer cornerX = Integer.parseInt(topCornerCoords[0]);
            Integer cornerY = Integer.parseInt(topCornerCoords[1].substring(0, topCornerCoords[1].length()-1));
            int spanX = Integer.parseInt(tokens[3].split("x")[0]);
            int spanY = Integer.parseInt(tokens[3].split("x")[1]);
            boolean viable = true;
            System.out.println();
            for (int x = cornerX; x < cornerX + spanX && viable; x++){
                for(int y = cornerY; y < cornerY + spanY && viable; y++){
                    Map<Integer, Boolean> column = usageMap.get(x);
                    if(column.get(y).booleanValue()){
                        viable = false;
                    }

                }
            }
            if(viable) {
                return patchId;
            }
        }
        return 0;
    }


    public static void main(String[] args){
        try{
           Map<Integer, Map<Integer,Boolean>> useageMap = Part1();
           int clearPatch = Part2(useageMap);
           System.out.println("Part 2 Answer: " + clearPatch);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
