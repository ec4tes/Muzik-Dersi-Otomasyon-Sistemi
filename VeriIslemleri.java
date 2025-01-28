import java.util.ArrayList;
import java.util.List;

public class VeriIslemleri {
    private List<Ogretmen> ogretmenListesi = new ArrayList<>();
    private List<Ogrenci> ogrenciListesi = new ArrayList<>();
    private List<Ders> dersListesi = new ArrayList<>();

    public void ogretmenEkle(Ogretmen ogretmen) {
        ogretmenListesi.add(ogretmen);
        DosyaIslemleri.dosyayaYaz("data/ogretmen.hot", ogretmenListesi);
    }

    public void ogrenciEkle(Ogrenci ogrenci) {
        ogrenciListesi.add(ogrenci);
        DosyaIslemleri.dosyayaYaz("data/ogrenci.hot", ogrenciListesi);
    }

    public void dersEkle(Ders ders) {
        dersListesi.add(ders);
        DosyaIslemleri.dosyayaYaz("data/ders.hot", dersListesi);
    }

    public void ogretmenSil(int ogretmenId) {
        ogretmenListesi.removeIf(ogretmen -> ogretmen.getId() == ogretmenId);
        dersListesi.removeIf(ders -> ders.getOgretmenId() == ogretmenId);
        DosyaIslemleri.dosyayaYaz("data/ogretmen.hot", ogretmenListesi);
        DosyaIslemleri.dosyayaYaz("data/ders.hot", dersListesi);
    }
}
