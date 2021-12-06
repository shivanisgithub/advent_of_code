import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diagnostics {

    public static void main(String[] args) {
        Diagnostics d = new Diagnostics();
        int power;
        try {
            power = d.processFile();
        } catch (FileNotFoundException e){
            power = 0;
        };
        System.out.println("power consumption:" + power);
    }

    public static int processFile() throws FileNotFoundException {
        int max_number = 0;
        Scanner scanner = new Scanner(new File("dataday3.txt"));
        int[] result = new int[12];

        while (scanner.hasNext()) {
            max_number++;
            char[] value = scanner.next().toCharArray();
            for (int i = 0; i < 12; i++) {
                result[i] = result[i] + value[i] - 48;
                System.out.println(result[i]);
            }
        }

        String gamma ="";
        String epsilon = "";

        System.out.println(max_number);

        for (int i = 0; i < 12; i++) {
            System.out.println(result[i]);
            if (result[i] < max_number/2){
                gamma += "0";
                epsilon += "1";
            }
            else {
                gamma += "1";
                epsilon += "0";
            }
        }

        int g = Integer.parseInt(gamma,2);
        System.out.println(g);
        int e = Integer.parseInt(epsilon,2);
        System.out.println(e);

        return g*e;
    }
}
