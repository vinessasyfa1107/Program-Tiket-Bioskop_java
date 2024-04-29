// File: Bioskop.java
package cinema;

public class Bioskop {
    private String nama;
    private String alamat;

    public Bioskop(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    @Override
    public String toString() {
        return nama;
    }
}
