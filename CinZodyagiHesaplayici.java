import java.util.Scanner;

public class CinZodyagiHesaplayici {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Doğum Yılınızı Giriniz: ");
        int dogumYili = scanner.nextInt();

        scanner.close();

        String[] cinZodyagi = {"Maymun", "Horoz", "Köpek", "Domuz", "Fare", "Öküz", "Kaplan", "Tavşan", "Ejderha", "Yılan", "At", "Koyun"};

        int zodyakIndex = dogumYili % 12;

        System.out.println("Çin Zodyağı Burcunuz: " + cinZodyagi[zodyakIndex]);
    }
}
