import java.util.Scanner;

public class TaksimetreHesaplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gidilen mesafeyi (KM) girin: ");
        int mesafe = scanner.nextInt();

        double acilisUcreti = 10.0;
        double birimFiyat = 2.20;

        double toplamTutar = acilisUcreti + (mesafe * birimFiyat);
        if (toplamTutar < 20.0) {
            toplamTutar = 20.0;
        }

        System.out.println("Taksimetre Tutarı: " + toplamTutar + " TL");
    }
}
