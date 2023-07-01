import java.util.ArrayList;
import java.util.List;

public class NumberThreadDemo {
    private static final int MAX_NUMBER = 10000;
    private static final int THREAD_COUNT = 4;

    private static List<Integer> evenNumbers = new ArrayList<>();
    private static List<Integer> oddNumbers = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        List<List<Integer>> numberChunks = splitNumbersIntoChunks(MAX_NUMBER, THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = createNumberThread(numberChunks.get(i));
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }

    private static List<List<Integer>> splitNumbersIntoChunks(int maxNumber, int threadCount) {
        List<List<Integer>> numberChunks = new ArrayList<>();
        int chunkSize = maxNumber / threadCount;

        int startNumber = 1;
        int endNumber = chunkSize;

        for (int i = 0; i < threadCount - 1; i++) {
            List<Integer> chunk = new ArrayList<>();
            for (int number = startNumber; number <= endNumber; number++) {
                chunk.add(number);
            }
            numberChunks.add(chunk);

            startNumber = endNumber + 1;
            endNumber += chunkSize;
        }

        // Last chunk might have slightly more numbers to cover the remainder
        List<Integer> lastChunk = new ArrayList<>();
        for (int number = startNumber; number <= maxNumber; number++) {
            lastChunk.add(number);
        }
        numberChunks.add(lastChunk);

        return numberChunks;
    }

    private static Thread createNumberThread(List<Integer> numbers) {
        return new Thread(() -> {
            for (int number : numbers) {
                if (number % 2 == 0) {
                    synchronized (evenNumbers) {
                        evenNumbers.add(number);
                    }
                } else {
                    synchronized (oddNumbers) {
                        oddNumbers.add(number);
                    }
                }
            }
        });
    }
}
