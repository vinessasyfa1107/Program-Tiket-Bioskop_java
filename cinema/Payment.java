// File: Payment.java
package cinema;

public class Payment {
    private String metodePembayaran;

    public Payment(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }
}