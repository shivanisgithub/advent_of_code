package d1p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

class DepthMeassurements {

    public static void main(String[] args) {
        DepthMeassurements dm = new DepthMeassurements();
        int[] intArray;
        try {
            intArray = dm.processFile();
        } catch (FileNotFoundException e){
            intArray = new int[0];
        };

        System.out.println("meassurements increased: " + dm.GetMeasurementsLarger(intArray));
    }

    public static int[] processFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("d1p1/meassurements.txt"));
        List<Integer> meassurements = new ArrayList<Integer>();
        int i = 0;
        while(scanner.hasNextInt()){
            meassurements.add(scanner.nextInt());
        }

        int[] intArray = new int[meassurements.size()];
        for (int j = 0; j < intArray.length; j++) {
            intArray[j] = meassurements.get(j);
        }
        return intArray;
    }

    public static int GetMeasurementsLarger(int[] depth) {
        int returnValue = 0;
        int l = depth.length;
        for(int i = 1; i < l; i++) {
            if (depth[i] > depth[i-1]) {
                returnValue++;
            }
        }
        return returnValue;
    }
}