import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Fibonacci serisi eleman sayısını girin: ");
        int elemanSayisi = scanner.nextInt();

        scanner.close();

        int fib1 = 0;
        int fib2 = 1;

        System.out.print("Fibonacci serisi: ");

        for (int i = 1; i <= elemanSayisi; i++) {
            System.out.print(fib1 + " ");

            int yeniFib = fib1 + fib2;
            fib1 = fib2;
            fib2 = yeniFib;
        }
    }
}
