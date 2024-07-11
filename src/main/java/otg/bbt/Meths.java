package otg.bbt;

import java.io.*;

public class Meths {

    public static void writeToFile(int number, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(String.valueOf(number) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readAndSumNumbers(String filename) throws IOException {
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 10) {
                try {
                    sum += Integer.parseInt(line);
                    count++;
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат числа: " + line);
                }
            }
        }
        return sum;
    }

    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int prev1 = 0, prev2 = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }
}
