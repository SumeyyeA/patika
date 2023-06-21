/* Kural : Girilen sayı 0 veya negatif olduğu yere kadar girilen sayıdan 5 rakamını çıkarın. Her çıkarma işlemi sırasında ekrana son değeri yazdırın. Sayı negatif veya 0 olduktan sonra tekrar 5 ekleyin. Yine her ekleme işleminde sayının son değerini ekrana yazdırın.
Senaryolar

N Sayısı : 16
Çıktısı : 16 11 6 1 -4 1 6 11 16 
*/ 
import java.util.Scanner;

public class RecursiveNumberOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number N: ");
        int n = scanner.nextInt();

        scanner.close();

        performOperations(n);
    }

    public static void performOperations(int number) {
        System.out.print(number + " ");

        if (number <= 0) {
            System.out.print("\n");
            return;
        }

        performOperations(number - 5);

        System.out.print(number + " ");
    }
}
