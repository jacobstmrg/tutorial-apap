package apap.tutorial.haidokter.model;

public class ResepModel{
    private String noResep;
    private String namaDokter;
    private String namaPasien;
    private String catatan;

    public ResepModel(String noResep, String namaDokter, String namaPasien, String catatan) {
        this.noResep = noResep;
        this.namaDokter = namaDokter;
        this.namaPasien = namaPasien;
        this.catatan = catatan;
    }

    public String getNoResep() {
        return noResep;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setNoResep(String noResep) {
        this.noResep = noResep;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
