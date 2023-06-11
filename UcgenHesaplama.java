import java.util.Scanner;

public class UcgenHesaplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinci dik kenarın uzunluğunu girin: ");
        double dikKenar1 = scanner.nextDouble();

        System.out.print("İkinci dik kenarın uzunluğunu girin: ");
        double dikKenar2 = scanner.nextDouble();

        double hipotenüs = Math.sqrt((dikKenar1 * dikKenar1) + (dikKenar2 * dikKenar2));
        System.out.println("Hipotenüs: " + hipotenüs);

        System.out.print("Üçgenin birinci kenar uzunluğunu girin: ");
        double kenar1 = scanner.nextDouble();

        System.out.print("Üçgenin ikinci kenar uzunluğunu girin: ");
        double kenar2 = scanner.nextDouble();

        System.out.print("Üçgenin üçüncü kenar uzunluğunu girin: ");
        double kenar3 = scanner.nextDouble();

        double u = (kenar1 + kenar2 + kenar3) / 2.0;
        double alan = Math.sqrt(u * (u - kenar1) * (u - kenar2) * (u - kenar3));

        System.out.println("Üçgenin Alanı: " + alan);
    }
}
