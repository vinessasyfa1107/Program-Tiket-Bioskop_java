// File: FormPanel.java
package gui;

import cinema.Bioskop;
import cinema.Film;
import cinema.Food;
import cinema.KelasBioskop;
import cinema.Order;
import cinema.Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FormPanel extends JPanel {
    private JComboBox<Bioskop> bioskopComboBox;
    private JComboBox<KelasBioskop> kelasBioskopComboBox;
    private JComboBox<Film> filmComboBox;
    private JComboBox<Food> makananComboBox;
    private JComboBox<String> jumlahTiketComboBox;
    private JTextField namaField;
    private JComboBox<String> pembayaranComboBox;
    private JButton submitButton;
    private KursiPanel kursiPanel;

    public FormPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        // Nama
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(new JLabel("Nama"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        namaField = new JTextField(10);
        add(namaField, gridBagConstraints);

        // Bioskop
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(new JLabel("Bioskop"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        bioskopComboBox = new JComboBox<>();
        bioskopComboBox.addItem(new Bioskop("-- Pilih Bioskop --", "-"));
        bioskopComboBox.addItem(new Bioskop("Bioskop A", "Alamat A"));
        bioskopComboBox.addItem(new Bioskop("Bioskop B", "Alamat B"));
        add(bioskopComboBox, gridBagConstraints);

        // Kelas Bioskop
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(new JLabel("Kelas Bioskop"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        kelasBioskopComboBox = new JComboBox<>();
        kelasBioskopComboBox.addItem(new KelasBioskop("-- Pilih Kelas Bioskop --", 0));
        kelasBioskopComboBox.addItem(new KelasBioskop("Reguler", 50000));
        kelasBioskopComboBox.addItem(new KelasBioskop("IMAXimum", 70000));
        kelasBioskopComboBox.addItem(new KelasBioskop("Premium", 100000));
        kelasBioskopComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof KelasBioskop) {
                    KelasBioskop kelasBioskop = (KelasBioskop) value;
                    if (kelasBioskop.getHarga() == 0) {
                        value = kelasBioskop.getNama();
                    } else
                    value = kelasBioskop.getNama() + " (Rp " + kelasBioskop.getHarga() + ")";
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        add(kelasBioskopComboBox, gridBagConstraints);


        // Film
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(new JLabel("Film"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        filmComboBox = new JComboBox<>();
        filmComboBox.addItem(new Film("-- Pilih Film --", "-"));
        filmComboBox.addItem(new Film("Film A", "Genre A"));
        filmComboBox.addItem(new Film("Film B", "Genre B"));
        add(filmComboBox, gridBagConstraints);

        // Jumlah Tiket
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(new JLabel("Jumlah Tiket"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jumlahTiketComboBox = new JComboBox<>();
        jumlahTiketComboBox.addItem("-- Pilih Jumlah Tiket --");
        for (int i = 1; i <= 5; i++) {
            jumlahTiketComboBox.addItem(Integer.toString(i));
        }
        add(jumlahTiketComboBox, gridBagConstraints);

        // Makanan
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        add(new JLabel("Makanan"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        makananComboBox = new JComboBox<>();
        makananComboBox.addItem(new Food("-- Pilih Makanan --", 0));
        makananComboBox.addItem(new Food("Makanan A", 25000));
        makananComboBox.addItem(new Food("Makanan B", 30000));
        makananComboBox.addItem(new Food("Makanan C", 35000));
        makananComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Food) {
                    Food food = (Food) value;
                    // jika harga 0, maka tampilkan nama makanan saja
                    if
                    (food.getHarga() == 0) value = food.getNama();
                    else
                    value = food.getNama() + " (Rp " + food.getHarga() + ")";
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        add(makananComboBox, gridBagConstraints);


        // Pembayaran
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        add(new JLabel("Pembayaran"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        pembayaranComboBox = new JComboBox<>();
        pembayaranComboBox.addItem("-- Pilih Pembayaran --");
        pembayaranComboBox.addItem("Cash");
        pembayaranComboBox.addItem("Credit Card");
        add(pembayaranComboBox, gridBagConstraints);

        // Kursi
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        kursiPanel = new KursiPanel(5, 5, 1);
        add(kursiPanel, gridBagConstraints);

        // Tambahkan tulisan "Layar disini", dengan tulisan ditengah dan memiliki border persegi panjang
        JLabel layarLabel = new JLabel("Layar disini");
        layarLabel.setHorizontalAlignment(JLabel.CENTER);
        layarLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        add(layarLabel, gridBagConstraints);

        // Submit Button
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        submitButton = new JButton("Submit");
        add(submitButton, gridBagConstraints);

        // Total Harga
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        add(new JLabel("Total Harga: "), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        JLabel totalHargaLabel = new JLabel("Rp 0");
        add(totalHargaLabel, gridBagConstraints);

        jumlahTiketComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalHarga(totalHargaLabel);
            }
        });

        kelasBioskopComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalHarga(totalHargaLabel);
            }
        });

        makananComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalHarga(totalHargaLabel);
            }
        });

        pembayaranComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalHarga(totalHargaLabel);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });


        // Submit Button
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        submitButton = new JButton("Submit");
        add(submitButton, gridBagConstraints);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        jumlahTiketComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                int jumlahTiket = Integer.parseInt((String) comboBox.getSelectedItem());
                kursiPanel.removeAll();
                kursiPanel.setLayout(new GridLayout(5, 5, 5, 5));
                kursiPanel.revalidate();
                kursiPanel.repaint();
                kursiPanel = new KursiPanel(5, 5, jumlahTiket);
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.gridwidth = 2;
                gridBagConstraints.anchor = GridBagConstraints.NORTH;
                add(kursiPanel, gridBagConstraints);
                revalidate();
                repaint();
            }
        });
    }

    private void updateTotalHarga(JLabel totalHargaLabel) {
        try {
            KelasBioskop kelasBioskop = (KelasBioskop) kelasBioskopComboBox.getSelectedItem();
            int jumlahTiket = Integer.parseInt((String) jumlahTiketComboBox.getSelectedItem());
            Food makanan = (Food) makananComboBox.getSelectedItem();

            Order order = new Order(null, jumlahTiket, makanan, null, kelasBioskop);
            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            double totalHarga = order.getTotalHarga();

            totalHargaLabel.setText("Rp " + decimalFormat.format(totalHarga));
        } catch (NumberFormatException ex) {
            totalHargaLabel.setText("Rp 0");
        }
    }

    private void submitForm() {

        String nama = namaField.getText();

        try {
            // Memeriksa bahwa user memasukkan nama menggunakan huruf dan spasi yang benar
            if (!nama.matches("[a-zA-Z\\s]+")) {
                throw new IllegalArgumentException("Input nama Anda menggunakan huruf dan spasi yang benar!");
            }
            // Memeriksa bahwa user memilih bioskop
            else if (bioskopComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("Anda belum memilih bioskop!");
            }
            // Memeriksa bahwa user memilih kelas bioskop
            else if (kelasBioskopComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("Anda belum memilih kelas bioskop!");
            }
            // Memeriksa bahwa user memilih film
            else if (filmComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("Anda belum memilih film!");
            }
            // Memeriksa bahwa user memilih jumlah tiket
            else if (jumlahTiketComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("Anda belum memilih jumlah tiket!");
            }
            // Memeriksa bahwa user memilih metode pembayaran
            else if (pembayaranComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("Anda belum memilih metode pembayaran!");
            }
            // Memeriksa bahwa user memilih kursi
            else if (kursiPanel.getKursiDipilih().size() == 0) {
                throw new IllegalArgumentException("Anda belum memilih kursi!");
            }
            // Memeriksa bahwa user memilih kursi sesuai dengan jumlah tiket
            else if (kursiPanel.getKursiDipilih().size() != Integer.parseInt((String) jumlahTiketComboBox.getSelectedItem())) {
                throw new IllegalArgumentException("Anda harus memilih kursi sebanyak jumlah tiket!");
            }


            Bioskop bioskop = (Bioskop) bioskopComboBox.getSelectedItem();
            KelasBioskop kelasBioskop = (KelasBioskop) kelasBioskopComboBox.getSelectedItem();
            Film film = (Film) filmComboBox.getSelectedItem();
            int jumlahTiket = Integer.parseInt((String) jumlahTiketComboBox.getSelectedItem());
            Food makanan = (Food) makananComboBox.getSelectedItem();
            String metodePembayaran = (String) pembayaranComboBox.getSelectedItem();
            ArrayList<String> kursiDipilih = kursiPanel.getKursiDipilih();

            Order order = new Order(film, jumlahTiket, makanan, bioskop, kelasBioskop);
            Payment payment = new Payment(metodePembayaran);

            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            double totalHarga = order.getTotalHarga();

            String kursiDipilihText = "No. Kursi: ";
            for (String kursi : kursiDipilih) {
                kursiDipilihText += kursi + ", ";
            }
            if (kursiDipilihText.endsWith(", ")) {
                kursiDipilihText = kursiDipilihText.substring(0, kursiDipilihText.length() - 2);
            }

            // jika makananan tidak dipilih, maka print outnya tidak ada makanan


            String summary = "Nama: " + nama + "\n" +
                    "Bioskop: " + bioskop.getNama() + " (" + bioskop.getAlamat() + ")\n" +
                    "Kelas Bioskop: " + kelasBioskop.getNama() + " - Rp " + decimalFormat.format(kelasBioskop.getHarga()) + "\n" +
                    "Film: " + film.getJudul() + " (" + film.getGenre() + ")\n" +
                    "Jumlah Tiket: " + jumlahTiket + "\n" +
                    printMakanan() +
                    "Metode Pembayaran: " + metodePembayaran + "\n" +
                    kursiDipilihText + "\n" +
                    "Total Harga: Rp " + decimalFormat.format(totalHarga);

            JOptionPane.showMessageDialog(FormPanel.this, summary, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Jumlah Tiket harus angka.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // print makanan
    private String printMakanan() {
        String makananText = "";
        if (makananComboBox.getSelectedIndex() == 0) {
            makananText = "Makanan: -\n";
        } else {
            Food makanan = (Food) makananComboBox.getSelectedItem();
            makananText = "Makanan: " + makanan.getNama() + " - Rp " + makanan.getHarga() + "\n";
        }
        return makananText;
    }
}
