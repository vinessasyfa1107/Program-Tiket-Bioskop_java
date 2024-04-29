// File: KursiPanel.java
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KursiPanel extends JPanel   {
    private JButton[][] kursiButtons;
    private int jumlahTiket;
    private ArrayList<String> kursiDipilih;

    public KursiPanel(int baris, int kolom, int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
        kursiDipilih = new ArrayList<>();

        setLayout(new GridLayout(baris, kolom, 5, 5));
        kursiButtons = new JButton[baris][kolom];

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                kursiButtons[i][j] = new JButton(Character.toString((char) ('A' + i)) + (j + 1));
                kursiButtons[i][j].setFont(new Font("Arial", Font.PLAIN, 14));
                kursiButtons[i][j].setPreferredSize(new Dimension(60, 40));
                kursiButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        String kursi = button.getText();

                        if (kursiDipilih.contains(kursi)) {
                            kursiDipilih.remove(kursi);
                            button.setBackground(null);
                        } else {
                            if (kursiDipilih.size() < jumlahTiket) {
                                kursiDipilih.add(kursi);
                                button.setBackground(Color.GREEN);
                            }
                        }
                    }
                });
                add(kursiButtons[i][j]);
            }
        }
    }

    public ArrayList<String> getKursiDipilih() {
        return kursiDipilih;
    }
}
