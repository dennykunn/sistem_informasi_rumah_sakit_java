public class RekamMedis {
    private String idPasien;
    private String idDokter;
    private String tanggal;
    private String diagnosa;

    // Constructor
    public RekamMedis(String idPasien, String idDokter, String tanggal, String diagnosa) {
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.tanggal = tanggal;
        this.diagnosa = diagnosa;
    }

    // Getter dan Setter
    public String getIdPasien() { return idPasien; }
    public void setIdPasien(String idPasien) { this.idPasien = idPasien; }
    public String getIdDokter() { return idDokter; }
    public void setIdDokter(String idDokter) { this.idDokter = idDokter; }
    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    public String getDiagnosa() { return diagnosa; }
    public void setDiagnosa(String diagnosa) { this.diagnosa = diagnosa; }
}
