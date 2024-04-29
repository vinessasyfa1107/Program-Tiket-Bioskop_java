// File: Food.java
package cinema;

public class Food {
    private String nama;
    private double harga;

    public Food(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return nama;
    }
}
