package functionality;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);
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
    public static void closeScanner() {
        scanner.close();
    }
}

