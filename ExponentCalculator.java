import java.util.Scanner;

public class ExponentCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Taban değerini giriniz: ");
        int base = scanner.nextInt();

        System.out.print("Üs değerini giriniz: ");
        int exponent = scanner.nextInt();

        scanner.close();

        int result = calculateExponent(base, exponent);

        System.out.println("Sonuç: " + result);
    }

    public static int calculateExponent(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * calculateExponent(base, exponent - 1);
        }
    }
}
