import java.util.*;
import java.io.PrintStream;
import java.io.IOException;

public class Weather {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("How many days' temperature?");
        int days = keyboard.nextInt();
        int[] temps = new int[days];
        int sum = 0;

        for(int i = 0; i < days; i++) {
            System.out.println("Day " + (i + 1) + "'s high temp: ");
            temps[i] = keyboard.nextInt();
            sum += temps[i];
        }

        double average = (double) sum / days;
        int count = 0;

        for(int i = 0; i < days; i++) {
            if(temps[i] > average) {
                count++;
            }
        }

        Arrays.sort(temps);

        try {
            PrintStream output = new PrintStream("weather_output.txt");

            output.printf("Average temp = %.2f", average);
            output.println();
            output.println(count + " day(s) above average");
            output.println("Temperatures: " + Arrays.toString(temps));
            output.println("Two coldest days: " + temps[0] + ", " + temps[1]);
            output.println("Two hottest days: " + temps[temps.length - 1] + ", " + temps[temps.length - 2]);

            output.close();
            System.out.println("Output written to 'weather_output.txt'");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        keyboard.close();
    }
}