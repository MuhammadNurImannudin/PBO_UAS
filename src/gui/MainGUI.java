/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import model.Barang;
import model.Pemesanan;
import model.Pembayaran;
import dao.CRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainGUI extends JFrame {
    private JPanel barangPanel, pemesananPanel, pembayaranPanel;
    private JTabbedPane tabbedPane;
    
    private JTextField barangIdField, barangNamaField, barangKategoriField, barangHargaField;
    private JTextArea barangTextArea;
    private JButton tambahBarangButton, tampilkanBarangButton;

    private JTextField pemesananTglField, pemesananDesField, pemesananJasaField, pemesananPajakField, pemesananBiayaField;
    private JTextArea pemesananTextArea;
    private JButton tambahPemesananButton, tampilkanPemesananButton;

    private JTextField pembayaranTglField, pembayaranJenisField, pembayaranDesField, pembayaranTotalField;
    private JTextArea pembayaranTextArea;
    private JButton tambahPembayaranButton, tampilkanPembayaranButton;

    public MainGUI() {
        setTitle("Manajemen Data");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        barangPanel = new JPanel();
        pemesananPanel = new JPanel();
        pembayaranPanel = new JPanel();

        setupBarangPanel();
        setupPemesananPanel();
        setupPembayaranPanel();

        tabbedPane.addTab("Barang", barangPanel);
        tabbedPane.addTab("Pemesanan", pemesananPanel);
        tabbedPane.addTab("Pembayaran", pembayaranPanel);

        add(tabbedPane);
    }

    private void setupBarangPanel() {
        barangPanel.setLayout(new GridLayout(6, 2));

        barangPanel.add(new JLabel("ID Barang:"));
        barangIdField = new JTextField();
        barangPanel.add(barangIdField);

        barangPanel.add(new JLabel("Nama Barang:"));
        barangNamaField = new JTextField();
        barangPanel.add(barangNamaField);

        barangPanel.add(new JLabel("Kategori Barang:"));
        barangKategoriField = new JTextField();
        barangPanel.add(barangKategoriField);

        barangPanel.add(new JLabel("Harga Barang:"));
        barangHargaField = new JTextField();
        barangPanel.add(barangHargaField);

        tambahBarangButton = new JButton("Tambah Barang");
        barangPanel.add(tambahBarangButton);
        tampilkanBarangButton = new JButton("Tampilkan Barang");
        barangPanel.add(tampilkanBarangButton);

        barangTextArea = new JTextArea();
        barangPanel.add(new JScrollPane(barangTextArea));

        CRUD crud = new CRUD();

        tambahBarangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(barangIdField.getText());
                String nama = barangNamaField.getText();
                String kategori = barangKategoriField.getText();
                double harga = Double.parseDouble(barangHargaField.getText());

                Barang barang = new Barang(id, nama, kategori, harga);
                crud.tambahBarang(barang);

                barangIdField.setText("");
                barangNamaField.setText("");
                barangKategoriField.setText("");
                barangHargaField.setText("");

                JOptionPane.showMessageDialog(null, "Barang berhasil ditambahkan");
            }
        });

        tampilkanBarangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Barang> barangList = crud.tampilkanBarang();
                StringBuilder sb = new StringBuilder();
                for (Barang barang : barangList) {
                    sb.append(barang).append("\n");
                }
                barangTextArea.setText(sb.toString());
            }
        });
    }

    private void setupPemesananPanel() {
        pemesananPanel.setLayout(new GridLayout(6, 2));

        pemesananPanel.add(new JLabel("Tanggal Pesan:"));
        pemesananTglField = new JTextField();
        pemesananPanel.add(pemesananTglField);

        pemesananPanel.add(new JLabel("Deskripsi Pesan:"));
        pemesananDesField = new JTextField();
        pemesananPanel.add(pemesananDesField);

        pemesananPanel.add(new JLabel("Jasa:"));
        pemesananJasaField = new JTextField();
        pemesananPanel.add(pemesananJasaField);

        pemesananPanel.add(new JLabel("Pajak:"));
        pemesananPajakField = new JTextField();
        pemesananPanel.add(pemesananPajakField);

        pemesananPanel.add(new JLabel("Biaya:"));
        pemesananBiayaField = new JTextField();
        pemesananPanel.add(pemesananBiayaField);

        tambahPemesananButton = new JButton("Tambah Pemesanan");
        pemesananPanel.add(tambahPemesananButton);
        tampilkanPemesananButton = new JButton("Tampilkan Pemesanan");
        pemesananPanel.add(tampilkanPemesananButton);

        pemesananTextArea = new JTextArea();
        pemesananPanel.add(new JScrollPane(pemesananTextArea));

        CRUD crud = new CRUD();

        tambahPemesananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tglPesan = pemesananTglField.getText();
                String desPesan = pemesananDesField.getText();
                String jasa = pemesananJasaField.getText();
                double pajak = Double.parseDouble(pemesananPajakField.getText());
                double biaya = Double.parseDouble(pemesananBiayaField.getText());

                Pemesanan pemesanan = new Pemesanan(tglPesan, desPesan, jasa, pajak, biaya);
                crud.tambahPemesanan(pemesanan);

                pemesananTglField.setText("");
                pemesananDesField.setText("");
                pemesananJasaField.setText("");
                pemesananPajakField.setText("");
                pemesananBiayaField.setText("");

                JOptionPane.showMessageDialog(null, "Pemesanan berhasil ditambahkan");
            }
        });

        tampilkanPemesananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pemesanan> pemesananList = crud.tampilkanPemesanan();
                StringBuilder sb = new StringBuilder();
                for (Pemesanan pemesanan : pemesananList) {
                    sb.append(pemesanan).append("\n");
                }
                pemesananTextArea.setText(sb.toString());
            }
        });
    }

    private void setupPembayaranPanel() {
        pembayaranPanel.setLayout(new GridLayout(6, 2));

        pembayaranPanel.add(new JLabel("Tanggal Bayar:"));
        pembayaranTglField = new JTextField();
        pembayaranPanel.add(pembayaranTglField);

        pembayaranPanel.add(new JLabel("Jenis Bayar:"));
        pembayaranJenisField = new JTextField();
        pembayaranPanel.add(pembayaranJenisField);

        pembayaranPanel.add(new JLabel("Deskripsi Bayar:"));
        pembayaranDesField = new JTextField();
        pembayaranPanel.add(pembayaranDesField);

        pembayaranPanel.add(new JLabel("Total:"));
        pembayaranTotalField = new JTextField();
        pembayaranPanel.add(pembayaranTotalField);

        tambahPembayaranButton = new JButton("Tambah Pembayaran");
        pembayaranPanel.add(tambahPembayaranButton);
        tampilkanPembayaranButton = new JButton("Tampilkan Pembayaran");
        pembayaranPanel.add(tampilkanPembayaranButton);

        pembayaranTextArea = new JTextArea();
        pembayaranPanel.add(new JScrollPane(pembayaranTextArea));

        CRUD crud = new CRUD();

        tambahPembayaranButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tglBayar = pembayaranTglField.getText();
                String jenisBayar = pembayaranJenisField.getText();
                String desBayar = pembayaranDesField.getText();
                double total = Double.parseDouble(pembayaranTotalField.getText());

                Pembayaran pembayaran = new Pembayaran(tglBayar, jenisBayar, desBayar, total);
                crud.tambahPembayaran(pembayaran);

                pembayaranTglField.setText("");
                pembayaranJenisField.setText("");
                pembayaranDesField.setText("");
                pembayaranTotalField.setText("");

                JOptionPane.showMessageDialog(null, "Pembayaran berhasil ditambahkan");
            }
        });

        tampilkanPembayaranButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pembayaran> pembayaranList = crud.tampilkanPembayaran();
                StringBuilder sb = new StringBuilder();
                for (Pembayaran pembayaran : pembayaranList) {
                    sb.append(pembayaran).append("\n");
                }
                pembayaranTextArea.setText(sb.toString());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
}
