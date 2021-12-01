package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class DepthMeassurements {

    public static void main(String[] args) {
        DepthMeassurements dm = new DepthMeassurements();
        int[] intArray;
        try {
            intArray = dm.processFile();
        } catch (FileNotFoundException e){
            intArray = new int[0];
        };

        System.out.println("meassurements increased: " + dm.GetMeasurementsLarger(dm.ArrayOfSums(intArray)));
    }

    public static int[] processFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("day1/meassurements.txt"));
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

    public static int[] ArrayOfSums(int[] depth) {
        int l = depth.length;
        int[] returnValues = new int[l-2];
        for(int i = 0; i < l-2; i++) {
            returnValues[i] = (depth[i]+depth[i+1]+depth[i+2]);
        }
        return returnValues;
    }
}