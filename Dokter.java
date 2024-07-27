public class Dokter {
    private String id;
    private String nama;
    private String spesialis;
    private String noTelp;

    // Constructor
    public Dokter(String id, String nama, String spesialis, String noTelp) {
        this.id = id;
        this.nama = nama;
        this.spesialis = spesialis;
        this.noTelp = noTelp;
    }

    // Getter dan Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getSpesialis() { return spesialis; }
    public void setSpesialis(String spesialis) { this.spesialis = spesialis; }
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
}
