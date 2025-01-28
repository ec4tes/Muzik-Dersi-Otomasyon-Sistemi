public class Ogretmen {
    private int id;
    private String adSoyad;
    private String brans;
    private String telefon;

    public Ogretmen(int id, String adSoyad, String brans, String telefon) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.brans = brans;
        this.telefon = telefon;
    }

    public int getId() { return id; }
    public String getAdSoyad() { return adSoyad; }
    public String getBrans() { return brans; }
    public String getTelefon() { return telefon; }

    @Override
    public String toString() {
        return id + "|" + adSoyad + "|" + brans + "|" + telefon;
    }
}
