package functionality;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    // Private constructor to prevent instantiation
    private InputHelper() {}

    public static String readLine() {
        return scanner.nextLine();
    }

    public static int readInt() {
        return scanner.nextInt();
    }

    public static double readDouble() {
        return scanner.nextDouble();
    }

    // Add more helper methods as needed

    public static void closeScanner() {
        scanner.close();
    }
}

