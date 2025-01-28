import java.io.File;
import java.io.IOException;

public class DosyaKontrol {

    public static void dosyalariKontrolEt() {
        try {
            // 1. Data klasörünü oluştur
            File dataKlasoru = new File("data");
            if (!dataKlasoru.exists()) {
                dataKlasoru.mkdir(); // Klasör oluşturulur
                System.out.println("data klasörü oluşturuldu.");
            }

            // 2. ogretmen.hot dosyasını oluştur
            File ogretmenDosya = new File("data/ogretmen.hot");
            if (!ogretmenDosya.exists()) {
                ogretmenDosya.createNewFile();
                System.out.println("ogretmen.hot dosyası oluşturuldu.");
            }

            // 3. ogrenci.hot dosyasını oluştur
            File ogrenciDosya = new File("data/ogrenci.hot");
            if (!ogrenciDosya.exists()) {
                ogrenciDosya.createNewFile();
                System.out.println("ogrenci.hot dosyası oluşturuldu.");
            }

            // 4. ders.hot dosyasını oluştur
            File dersDosya = new File("data/ders.hot");
            if (!dersDosya.exists()) {
                dersDosya.createNewFile();
                System.out.println("ders.hot dosyası oluşturuldu.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
