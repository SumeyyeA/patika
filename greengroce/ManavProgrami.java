import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManavProgrami {
    public static void main(String[] args) {
        // Meyveler ve kilogram fiyatlarını tanımla
        Map<String, Double> meyveler = new HashMap<>();
        meyveler.put("Armut", 2.14);
        meyveler.put("Elma", 3.67);
        meyveler.put("Domates", 1.11);
        meyveler.put("Muz", 0.95);
        meyveler.put("Patlıcan", 5.00);

        // Kullanıcıdan alınacak ürünleri ve kilogram değerlerini tutacak değişkenler
        String urun;
        double kilogram;
        double toplamTutar = 0;

        // Kullanıcıdan ürünleri ve kilogram değerlerini al
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ürünü girin (Çıkmak veya toplam tutar için 'q' tuşuna basın): ");
            urun = scanner.nextLine();

            if (urun.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Kilogram değerini girin: ");
            kilogram = scanner.nextDouble();
            scanner.nextLine(); // Boş satırı oku

            // Toplam tutarı hesapla
            if (meyveler.containsKey(urun)) {
                double fiyat = meyveler.get(urun);
                double tutar = fiyat * kilogram;
                toplamTutar += tutar;
                System.out.println(urun + " " + kilogram + " kg için ödenecek tutar: " + tutar + " TL");
            } else {
                System.out.println("Geçersiz bir ürün girdiniz.");
            }
        }

        // Toplam tutarı ekrana yazdır
        System.out.println("Toplam tutar: " + toplamTutar + " TL");
    }
}
