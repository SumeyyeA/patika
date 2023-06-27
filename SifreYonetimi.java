import java.util.Scanner;

public class SifreYonetimi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dogruSifre = "123"; // 

        System.out.print("Şifreyi girin: ");
        String girilenSifre = scanner.nextLine();

        if (girilenSifre.length() == dogruSifre.length()) {
            boolean sifreEsit = true;

            for (int i = 0; i < girilenSifre.length(); i++) {
                if (girilenSifre.charAt(i) != dogruSifre.charAt(i)) {
                    sifreEsit = false;
                    break;
                }
            }

            if (sifreEsit) {
                System.out.println("Giriş başarılı!");
            } else {
                System.out.println("Şifre yanlış!");

                System.out.print("Şifrenizi sıfırlamak ister misiniz? (evet/hayır): ");
                String sifreSifirla = scanner.nextLine();

                if (sifreSifirla.equalsIgnoreCase("evet")) {
                    System.out.print("Yeni şifreyi girin: ");
                    String yeniSifre = scanner.nextLine();

                    boolean eskiSifreIleAyni = true;
                    if (yeniSifre.length() == dogruSifre.length()) {
                        for (int i = 0; i < yeniSifre.length(); i++) {
                            if (yeniSifre.charAt(i) == dogruSifre.charAt(i)) {
                                eskiSifreIleAyni = false;
                                break;
                            }
                        }
                    } else {
                        eskiSifreIleAyni = false;
                    }

                    if (eskiSifreIleAyni) {
                        System.out.println("Şifre oluşturulamadı, lütfen başka bir şifre giriniz.");
                    } else {
                        System.out.println("Şifre oluşturuldu.");
                    }
                }
            }
        } else {
            System.out.println("Şifre yanlış!");
        }
    }
}
