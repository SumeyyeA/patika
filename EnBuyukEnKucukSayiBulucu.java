import java.util.Scanner;

public class EnBuyukEnKucukSayiBulucu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kaç tane sayı gireceksiniz: ");
        int n = scanner.nextInt();

        int enBuyukSayi = Integer.MIN_VALUE;
        int enKucukSayi = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ". Sayıyı giriniz: ");
            int sayi = scanner.nextInt();

            if (sayi > enBuyukSayi) {
                enBuyukSayi = sayi;
            }

            if (sayi < enKucukSayi) {
                enKucukSayi = sayi;
            }
        }

        scanner.close();

        System.out.println("En büyük sayı: " + enBuyukSayi);
        System.out.println("En küçük sayı: " + enKucukSayi);
    }
}
