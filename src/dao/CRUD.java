/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.DatabaseUtil;
import model.Barang;
import model.Pemesanan;
import model.Pembayaran;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD {

    // CRUD Operations for Barang
    public void tambahBarang(Barang barang) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO barang (id, nama, kategori, harga) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, barang.getId());
            stmt.setString(2, barang.getNama());
            stmt.setString(3, barang.getKategori());
            stmt.setDouble(4, barang.getHarga());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Barang> tampilkanBarang() {
        List<Barang> daftarBarang = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM barang";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String kategori = rs.getString("kategori");
                double harga = rs.getDouble("harga");
                daftarBarang.add(new Barang(id, nama, kategori, harga));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarBarang;
    }

    public void ubahBarang(Barang barang) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "UPDATE barang SET nama = ?, kategori = ?, harga = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, barang.getNama());
            stmt.setString(2, barang.getKategori());
            stmt.setDouble(3, barang.getHarga());
            stmt.setInt(4, barang.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapusBarang(int id) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM barang WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CRUD Operations for Pemesanan
    public void tambahPemesanan(Pemesanan pemesanan) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO pemesanan (tglPesan, desPesan, jasa, pajak, biaya) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pemesanan.getTglPesan());
            stmt.setString(2, pemesanan.getDesPesan());
            stmt.setString(3, pemesanan.getJasa());
            stmt.setDouble(4, pemesanan.getPajak());
            stmt.setDouble(5, pemesanan.getBiaya());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pemesanan> tampilkanPemesanan() {
        List<Pemesanan> daftarPemesanan = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM pemesanan";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tglPesan = rs.getString("tglPesan");
                String desPesan = rs.getString("desPesan");
                String jasa = rs.getString("jasa");
                double pajak = rs.getDouble("pajak");
                double biaya = rs.getDouble("biaya");
                daftarPemesanan.add(new Pemesanan(tglPesan, desPesan, jasa, pajak, biaya));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarPemesanan;
    }

    public void ubahPemesanan(Pemesanan pemesanan) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "UPDATE pemesanan SET desPesan = ?, jasa = ?, pajak = ?, biaya = ? WHERE tglPesan = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pemesanan.getDesPesan());
            stmt.setString(2, pemesanan.getJasa());
            stmt.setDouble(3, pemesanan.getPajak());
            stmt.setDouble(4, pemesanan.getBiaya());
            stmt.setString(5, pemesanan.getTglPesan());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapusPemesanan(String tglPesan) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM pemesanan WHERE tglPesan = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tglPesan);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CRUD Operations for Pembayaran
    public void tambahPembayaran(Pembayaran pembayaran) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO pembayaran (tglBayar, jenisBayar, desBayar, total) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pembayaran.getTglBayar());
            stmt.setString(2, pembayaran.getJenisBayar());
            stmt.setString(3, pembayaran.getDesBayar());
            stmt.setDouble(4, pembayaran.getTotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pembayaran> tampilkanPembayaran() {
        List<Pembayaran> daftarPembayaran = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM pembayaran";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tglBayar = rs.getString("tglBayar");
                String jenisBayar = rs.getString("jenisBayar");
                String desBayar = rs.getString("desBayar");
                double total = rs.getDouble("total");
                daftarPembayaran.add(new Pembayaran(tglBayar, jenisBayar, desBayar, total));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarPembayaran;
    }

    public void ubahPembayaran(Pembayaran pembayaran) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "UPDATE pembayaran SET jenisBayar = ?, desBayar = ?, total = ? WHERE tglBayar = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pembayaran.getJenisBayar());
            stmt.setString(2, pembayaran.getDesBayar());
            stmt.setDouble(3, pembayaran.getTotal());
            stmt.setString(4, pembayaran.getTglBayar());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapusPembayaran(String tglBayar) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM pembayaran WHERE tglBayar = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tglBayar);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

