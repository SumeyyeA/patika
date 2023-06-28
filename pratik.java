import java.util.Scanner;

public class pratik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 9) {
            System.out.println("1- Çift Sayıları Bulma");
            System.out.println("2- 3 ve 4'e Tam Bölünen Sayıların Ortalamasını Hesaplama");
            System.out.println("3- Tek Sayıları Toplama");
            System.out.println("4- 4 ve 5'in Kuvvetlerini Yazdırma");
            System.out.println("5- Kombinasyon Hesaplama");
            System.out.println("6- Basamak Sayılarının Toplamını Hesaplama");
            System.out.println("7- Harmonik Seri Hesaplama");
            System.out.println("8- Yıldızlarla Elmas Oluşturma");
            System.out.println("9- Çıkış");
            
            System.out.print("Bir seçenek girin (1-9): ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Bir sayı girin: ");
                    int number1 = scanner.nextInt();
                    System.out.println("Çift Sayılar:");
                    for (int i = 0; i <= number1; i++) {
                        if (i % 2 == 0) {
                            System.out.println(i);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Bir sayı girin: ");
                    int number2 = scanner.nextInt();
                    int sum = 0;
                    int count = 0;
                    for (int i = 0; i <= number2; i++) {
                        if (i % 3 == 0 && i % 4 == 0) {
                            sum += i;
                            count++;
                        }
                    }
                    double average = (double) sum / count;
                    System.out.println("Ortalama: " + average);
                    break;
                case 3:
                    int total = 0;
                    int num3;
                    do {
                        System.out.print("Bir sayı girin (Negatif değer girerek çıkış yapabilirsiniz): ");
                        num3 = scanner.nextInt();
                        if (num3 % 2 != 0 && num3 >= 0) {
                            total += num3;
                        }
                    } while (num3 >= 0);
                    System.out.println("Tek Sayıların Toplamı: " + total);
                    break;
                case 4:
                    System.out.print("Bir sayı girin: ");
                    int number4 = scanner.nextInt();
                    System.out.println("4 ve 5'in Kuvvetleri:");
                    for (int i = 1; i <= number4; i++) {
                        System.out.println("4^" + i + " = " + Math.pow(4, i));
                        System.out.println("5^" + i + " = " + Math.pow(5, i));
                    }
                    break;
                case 5:
                    System.out.print("N değerini girin: ");
                    int n = scanner.nextInt();
                    System.out.print("R değerini girin: ");
                    int r = scanner.nextInt();
                    int result = calculateCombination(n, r);
                    System.out.println("C(" + n + ", " + r + ") = " + result);
                    break;
                case 6:
                    System.out.print("Bir sayı girin: ");
                    int number6 = scanner.nextInt();
                    int sum6 = 0;
                    while (number6 > 0) {
                        sum6 += number6 % 10;
                        number6 /= 10;
                    }
                    System.out.println("Basamak Sayılarının Toplamı: " + sum6);
                    break;
                case 7:
                    System.out.print("Bir sayı girin: ");
                    int number7 = scanner.nextInt();
                    double harmonicSum = 0;
                    for (int i = 1; i <= number7; i++) {
                        harmonicSum += 1.0 / i;
                    }
                    System.out.println("Harmonik Seri: " + harmonicSum);
                    break;
                case 8:
                    System.out.print("Elmasın yüksekliğini girin: ");
                    int height = scanner.nextInt();
                    for (int i = 1; i <= height; i++) {
                        for (int j = 1; j <= height - i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (int i = height - 1; i >= 1; i--) {
                        for (int j = 1; j <= height - i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 9:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçenek!");
                    break;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static int calculateCombination(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        } else {
            return calculateCombination(n - 1, r - 1) + calculateCombination(n - 1, r);
        }
    }
}
