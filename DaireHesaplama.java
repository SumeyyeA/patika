import java.util.Scanner;

public class DaireHesaplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dairenin yarıçapını girin: ");
        double yaricap = scanner.nextDouble();

        double pi = 3.14;

        double alan = pi * yaricap * yaricap;
        double cevre = 2 * pi * yaricap;

        System.out.println("Dairenin Alanı: " + alan);
        System.out.println("Dairenin Çevresi: " + cevre);

        System.out.print("Merkez açısının ölçüsünü (𝛼) girin: ");
        double merkezAcisi = scanner.nextDouble();

        double dilimAlan = (pi * yaricap * yaricap * merkezAcisi) / 360.0;
        System.out.println("Daire Diliminin Alanı: " + dilimAlan);
    }
}
