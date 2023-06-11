import java.util.Scanner;

public class SinifGecmeDurumu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Matematik sınav puanınızı girin: ");
        int matematik = scanner.nextInt();

        System.out.print("Fizik sınav puanınızı girin: ");
        int fizik = scanner.nextInt();

        System.out.print("Kimya sınav puanınızı girin: ");
        int kimya = scanner.nextInt();

        System.out.print("Türkçe sınav puanınızı girin: ");
        int turkce = scanner.nextInt();

        System.out.print("Tarih sınav puanınızı girin: ");
        int tarih = scanner.nextInt();

        System.out.print("Müzik sınav puanınızı girin: ");
        int muzik = scanner.nextInt();

        int toplam = matematik + fizik + kimya + turkce + tarih + muzik;
        double ortalama = toplam / 6.0;

        System.out.println("Ortalamanız: " + ortalama);

        String sinifDurumu = (ortalama > 60) ? "Sınıfı Geçti" : "Sınıfta Kaldı";
        System.out.println(sinifDurumu);
    }
}
