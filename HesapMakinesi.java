import java.util.Scanner;

public class HesapMakinesi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("İlk sayıyı girin: ");
        double sayi1 = scanner.nextDouble();

        System.out.print("İkinci sayıyı girin: ");
        double sayi2 = scanner.nextDouble();

        System.out.print("İşlemi seçin (+, -, *, /): ");
        char islem = scanner.next().charAt(0);

        double sonuc = 0;

        if (islem == '+') {
            sonuc = sayi1 + sayi2;
        } else if (islem == '-') {
            sonuc = sayi1 - sayi2;
        } else if (islem == '*') {
            sonuc = sayi1 * sayi2;
        } else if (islem == '/') {
            sonuc = sayi1 / sayi2;
        } else {
            System.out.println("Geçersiz işlem!");
            System.exit(0); // Programı sonlandır
        }

        System.out.println("Sonuç: " + sonuc);
    }
}
