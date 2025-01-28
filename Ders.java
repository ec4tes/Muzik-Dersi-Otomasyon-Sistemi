public class Ders {
    private int id;
    private int ogretmenId;
    private int ogrenciId;
    private String tarih;
    private String sure;
    private String konu;

    public Ders(int id, int ogretmenId, int ogrenciId, String tarih, String sure, String konu) {
        this.id = id;
        this.ogretmenId = ogretmenId;
        this.ogrenciId = ogrenciId;
        this.tarih = tarih;
        this.sure = sure;
        this.konu = konu;
    }

    public int getId() { return id; }
    public int getOgretmenId() { return ogretmenId; }
    public int getOgrenciId() { return ogrenciId; }
    public String getTarih() { return tarih; }
    public String getSure() { return sure; }
    public String getKonu() { return konu; }

    @Override
    public String toString() {
        return id + "|" + ogretmenId + "|" + ogrenciId + "|" + tarih + "|" + sure + "|" + konu;
    }
}
