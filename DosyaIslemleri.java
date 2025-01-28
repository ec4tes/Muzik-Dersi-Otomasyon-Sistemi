import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DosyaIslemleri {

    public static List<String> dosyaOku(String dosyaAdi) {
        List<String> satirlar = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                satirlar.add(satir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return satirlar;
    }

    public static void dosyayaYaz(String dosyaAdi, List<?> veriListesi) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
            for (Object veri : veriListesi) {
                writer.write(veri.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
