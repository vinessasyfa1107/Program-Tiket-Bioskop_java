package cinema;

public class Order {
    private Film film;
    private int jumlahTiket;
    private Food makanan;
    private Bioskop bioskop;
    private KelasBioskop kelasBioskop;

    public Order(Film film, int jumlahTiket, Food makanan, Bioskop bioskop, KelasBioskop kelasBioskop) {
        this.film = film;
        this.jumlahTiket = jumlahTiket;
        this.makanan = makanan;
        this.bioskop = bioskop;
        this.kelasBioskop = kelasBioskop;
    }

    public double getTotalHarga() {
        double hargaTiket = kelasBioskop.getHarga();
        double hargaMakanan = (makanan != null) ? makanan.getHarga() : 0;
        double totalHarga = (hargaTiket * jumlahTiket) + hargaMakanan;
        return totalHarga;
    }

    public Film getFilm() {
        return film;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public Food getMakanan() {
        return makanan;
    }

    public Bioskop getBioskop() {
        return bioskop;
    }

    public KelasBioskop getKelasBioskop() {
        return kelasBioskop;
    }
}
