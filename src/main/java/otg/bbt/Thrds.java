package otg.bbt;

import java.io.IOException;

public class Thrds extends Meths {

    private static final Object lock = new Object();


    public static void main(String[] args) {

        Thread fibonacciThread = new Thread(new Runnable() {

            @Override
            public void run() {
                int result = fibonacci(15);
                synchronized (lock) {
                    writeToFile(result, "out.txt");
                }
            }
        });

        Thread readerSumThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    int sum = readAndSumNumbers("numbers.txt");
                    synchronized (lock) {
                        writeToFile(sum, "out.txt");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        fibonacciThread.start();
        readerSumThread.start();
    }
}
