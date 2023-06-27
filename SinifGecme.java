import java.util.Scanner;

public class SinifGecme {

    public static void main(String[] args) {
        // Kullanıcıdan ders notlarını almak için Scanner nesnesi
        Scanner scanner = new Scanner(System.in);

        // Toplam not ve geçerli not sayısı için değişkenler
        int toplam = 0;
        int sayac = 0;

        // Dersler dizisi
        String[] dersler = {"Matematik", "Fizik", "Türkçe", "Kimya", "Müzik"};

        // Geçme notu sabiti
        final int GECME_NOTU = 55;

        // Her ders için döngü
        for (String ders : dersler) {
            // Kullanıcıdan notu iste
            System.out.print(ders + " notunuz: ");
            int not = scanner.nextInt();

            // Notun 0 ile 100 arasında olup olmadığını kontrol et
            if (not >= 0 && not <= 100) {
                // Notu toplama ekle ve sayacı artır
                toplam += not;
                sayac++;
            }
            else {
                // Notu atla
                System.out.println("Geçersiz not.");
            }
        }

        // Ortalamayı hesapla
        double ortalama = (double) toplam / sayac;

        // Ortalamayı yazdır
        System.out.println("Ortalamanız: " + ortalama);

        // Sınıf geçme durumunu belirle
        if (ortalama >= GECME_NOTU) {
            System.out.println("Sınıfı geçtiniz.");
        }
        else {
            System.out.println("Sınıfı geçemediniz.");
        }

    }
}
