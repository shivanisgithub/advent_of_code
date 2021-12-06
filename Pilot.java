import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pilot {

    public static void main(String[] args) {
        Pilot p = new Pilot();
        List<int[]> intArrays;
        try {
            intArrays = p.processFile();
        } catch (FileNotFoundException e){
            intArrays = new ArrayList<>();
        };

        int result;
        try {
            result = p.processFileDifferently();
        } catch (FileNotFoundException e){
            result = 0;
        };

        System.out.println("sum of coordinates:" + p.Sum(intArrays.get(0)) * p.Sum(intArrays.get(1)));
        System.out.println("sum of coordinates after manual:" + result);


    }

    public static List<int[]> processFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("data.txt"));
        List<Integer> forward = new ArrayList<Integer>();
        List<Integer> depth = new ArrayList<Integer>();

        int i = 0;
        while(scanner.hasNext()){
            String next = scanner.next();
            if(next.equals("forward")){
                forward.add(scanner.nextInt());
            }
            if(next.equals("up")){
                depth.add(-1*scanner.nextInt());
            }
            if(next.equals("down")){
                depth.add(scanner.nextInt());
            }
        }

        int[] forwardArray = new int[forward.size()];
        for (int j = 0; j < forwardArray.length; j++) {
            forwardArray[j] = forward.get(j);
        }

        int[] depthArray = new int[depth.size()];
        for (int j = 0; j < depthArray.length; j++) {
            depthArray[j] = depth.get(j);
        }
        List result = new ArrayList<>();
        result.add(forwardArray);
        result.add(depthArray);

        return result;
    }

    public static int Sum(int[] values) {
        int result = 0;
        int l = values.length;
        for(int i = 0; i < l; i++) {
            result += values[i];
        }
        return result;
    }

    public static int processFileDifferently() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("data.txt"));
        int aim = 0;
        int horizontal = 0;
        int depth = 0;

        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equals("down")) {
                aim += scanner.nextInt();
            }
            if (next.equals("up")) {
                aim -= scanner.nextInt();
            }
            if (next.equals("forward")) {
                int nextInt = scanner.nextInt();
                horizontal += nextInt;
                depth += aim * nextInt;
            }
        }

        return horizontal*depth;
    }
}