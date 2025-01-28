public class Ogrenci {
    private int id;
    private String adSoyad;
    private int yas;
    private String telefon;

    public Ogrenci(int id, String adSoyad, int yas, String telefon) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.yas = yas;
        this.telefon = telefon;
    }

    public int getId() { return id; }
    public String getAdSoyad() { return adSoyad; }
    public int getYas() { return yas; }
    public String getTelefon() { return telefon; }

    @Override
    public String toString() {
        return id + "|" + adSoyad + "|" + yas + "|" + telefon;
    }
}
