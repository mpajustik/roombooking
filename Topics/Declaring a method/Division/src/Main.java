import java.util.Scanner;

public class Main {

    public static double divide(long a, long b) {
        // write your code here
        double sum = (double)a/(double)b;
        return sum;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final long a = scanner.nextLong();
        final long b = scanner.nextLong();
        System.out.println(divide(a, b));
    }
}