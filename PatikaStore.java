import java.util.*;

public class PatikaStore {
    private static List<Marka> markalar = new ArrayList<>();
    private static List<Notebook> notebooks = new ArrayList<>();
    private static List<CepTelefonu> cepTelefonlari = new ArrayList<>();

    public static void main(String[] args) {
        markaOlustur();

        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            menuYazdir();
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    notebookIslemleri();
                    break;
                case 2:
                    cepTelefonuIslemleri();
                    break;
                case 3:
                    markaListele();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
                    break;
            }
        } while (secim != 0);
    }

    public static void menuYazdir() {
        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonu İşlemleri");
        System.out.println("3 - Marka Listele");
        System.out.println("0 - Çıkış Yap");
        System.out.print("Tercihiniz: ");
    }

    public static void markaOlustur() {
        markalar.add(new Marka(1, "Samsung"));
        markalar.add(new Marka(2, "Lenovo"));
        markalar.add(new Marka(3, "Apple"));
        markalar.add(new Marka(4, "Huawei"));
        markalar.add(new Marka(5, "Casper"));
        markalar.add(new Marka(6, "Asus"));
        markalar.add(new Marka(7, "HP"));
        markalar.add(new Marka(8, "Xiaomi"));
        markalar.add(new Marka(9, "Monster"));

        Collections.sort(markalar, Comparator.comparing(Marka::getAd));
    }

    public static void markaListele() {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (Marka marka : markalar) {
            System.out.println("- " + marka.getAd());
        }
    }

    public static void notebookIslemleri() {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\nNotebook İşlemleri");
            System.out.println("1 - Notebook Listele");
            System.out.println("2 - Notebook Ekle");
            System.out.println("3 - Notebook Sil");
            System.out.println("0 - Geri Dön");
            System.out.print("Tercihiniz: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    notebookListele();
                    break;
                case 2:
                    notebookEkle();
                    break;
                case 3:
                    notebookSil();
                    break;
                case 0:
                    System.out.println("Notebook işlemlerinden çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
                    break;
            }
        } while (secim != 0);
    }

    public static void notebookListele() {
        System.out.println("\nNotebook Listesi");
        System.out.println("------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı               | Fiyat     | Marka    | RAM   | Depolama | Ekran   |");
        System.out.println("------------------------------------------------------------------");
        for (Notebook notebook : notebooks) {
            System.out.printf("| %-2d | %-23s | %-9.2f | %-7s | %-4dGB | %-8s |%n",
                    notebook.getId(), notebook.getUrunAdi(), notebook.getFiyat(), notebook.getMarka().getAd(),
                    notebook.getRam(), notebook.getDepolama());
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void notebookEkle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ürün Adı: ");
        String urunAdi = scanner.nextLine();

        System.out.print("Fiyat: ");
        double fiyat = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Marka ID: ");
        int markaId = scanner.nextInt();
        scanner.nextLine();
        Marka marka = markaBul(markaId);

        System.out.print("RAM (GB): ");
        int ram = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Depolama: ");
        String depolama = scanner.nextLine();

        System.out.print("Ekran: ");
        String ekran = scanner.nextLine();

        int id = notebooks.size() + 1;
        Notebook notebook = new Notebook(id, urunAdi, fiyat, marka, ram, depolama, ekran);
        notebooks.add(notebook);

        System.out.println("Notebook başarıyla eklendi.");
    }

    public static void notebookSil() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Silmek istediğiniz notebook ID'sini girin: ");
        int id = scanner.nextInt();

        boolean silindi = false;
        for (Notebook notebook : notebooks) {
            if (notebook.getId() == id) {
                notebooks.remove(notebook);
                silindi = true;
                break;
            }
        }

        if (silindi) {
            System.out.println("Notebook başarıyla silindi.");
        } else {
            System.out.println("ID'ye uygun notebook bulunamadı.");
        }
    }

    public static void cepTelefonuIslemleri() {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\nCep Telefonu İşlemleri");
            System.out.println("1 - Cep Telefonu Listele");
            System.out.println("2 - Cep Telefonu Ekle");
            System.out.println("3 - Cep Telefonu Sil");
            System.out.println("0 - Geri Dön");
            System.out.print("Tercihiniz: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    cepTelefonuListele();
                    break;
                case 2:
                    cepTelefonuEkle();
                    break;
                case 3:
                    cepTelefonuSil();
                    break;
                case 0:
                    System.out.println("Cep telefonu işlemlerinden çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
                    break;
            }
        } while (secim != 0);
    }

    public static void cepTelefonuListele() {
        System.out.println("\nCep Telefonu Listesi");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı               | Fiyat     | Marka    | Depolama | Ekran   | Kamera | Pil     | RAM   | Renk    |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (CepTelefonu cepTelefonu : cepTelefonlari) {
            System.out.printf("| %-2d | %-23s | %-9.2f | %-7s | %-8d | %-7s | %-6d | %-7.1f | %-4dGB | %-7s |%n",
                    cepTelefonu.getId(), cepTelefonu.getUrunAdi(), cepTelefonu.getFiyat(), cepTelefonu.getMarka().getAd(),
                    cepTelefonu.getDepolama(), cepTelefonu.getEkran(), cepTelefonu.getKamera(), cepTelefonu.getPil(),
                    cepTelefonu.getRam(), cepTelefonu.getRenk());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void cepTelefonuEkle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ürün Adı: ");
        String urunAdi = scanner.nextLine();

        System.out.print("Fiyat: ");
        double fiyat = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Marka ID: ");
        int markaId = scanner.nextInt();
        scanner.nextLine();
        Marka marka = markaBul(markaId);

        System.out.print("Depolama: ");
        int depolama = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ekran: ");
        double ekran = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Kamera: ");
        int kamera = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Pil: ");
        double pil = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("RAM (GB): ");
        int ram = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Renk: ");
        String renk = scanner.nextLine();

        int id = cepTelefonlari.size() + 1;
        CepTelefonu cepTelefonu = new CepTelefonu(id, urunAdi, fiyat, marka, depolama, ekran, kamera, pil, ram, renk);
        cepTelefonlari.add(cepTelefonu);

        System.out.println("Cep telefonu başarıyla eklendi.");
    }

    public static void cepTelefonuSil() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Silmek istediğiniz cep telefonu ID'sini girin: ");
        int id = scanner.nextInt();

        boolean silindi = false;
        for (CepTelefonu cepTelefonu : cepTelefonlari) {
            if (cepTelefonu.getId() == id) {
                cepTelefonlari.remove(cepTelefonu);
                silindi = true;
                break;
            }
        }

        if (silindi) {
            System.out.println("Cep telefonu başarıyla silindi.");
        } else {
            System.out.println("ID'ye uygun cep telefonu bulunamadı.");
        }
    }

    public static Marka markaBul(int markaId) {
        for (Marka marka : markalar) {
            if (marka.getId() == markaId) {
                return marka;
            }
        }
        return null;
    }
}

class Marka {
    private int id;
    private String ad;

    public Marka(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }
}

class Notebook {
    private int id;
    private String urunAdi;
    private double fiyat;
    private Marka marka;
    private int ram;
    private String depolama;
    private String ekran;

    public Notebook(int id, String urunAdi, double fiyat, Marka marka, int ram, String depolama, String ekran) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.marka = marka;
        this.ram = ram;
        this.depolama = depolama;
        this.ekran = ekran;
    }

    public int getId() {
        return id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public Marka getMarka() {
        return marka;
    }

    public int getRam() {
        return ram;
    }

    public String getDepolama() {
        return depolama;
    }

    public String getEkran() {
        return ekran;
    }
}

class CepTelefonu {
    private int id;
    private String urunAdi;
    private double fiyat;
    private Marka marka;
    private int depolama;
    private double ekran;
    private int kamera;
    private double pil;
    private int ram;
    private String renk;

    public CepTelefonu(int id, String urunAdi, double fiyat, Marka marka, int depolama, double ekran, int kamera,
                       double pil, int ram, String renk) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.marka = marka;
        this.depolama = depolama;
        this.ekran = ekran;
        this.kamera = kamera;
        this.pil = pil;
        this.ram = ram;
        this.renk = renk;
    }

    public int getId() {
        return id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public Marka getMarka() {
        return marka;
    }

    public int getDepolama() {
        return depolama;
    }

    public double getEkran() {
        return ekran;
    }

    public int getKamera() {
        return kamera;
    }

    public double getPil() {
        return pil;
    }

    public int getRam() {
        return ram;
    }

    public String getRenk() {
        return renk;
    }
}
