/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Pemesanan {
    private String tglPesan;
    private String desPesan;
    private String jasa;
    private double pajak;
    private double biaya;

    // Constructor, getters, setters, and toString method
    public Pemesanan(String tglPesan, String desPesan, String jasa, double pajak, double biaya) {
        this.tglPesan = tglPesan;
        this.desPesan = desPesan;
        this.jasa = jasa;
        this.pajak = pajak;
        this.biaya = biaya;
    }

    public String getTglPesan() {
        return tglPesan;
    }

    public String getDesPesan() {
        return desPesan;
    }

    public String getJasa() {
        return jasa;
    }

    public double getPajak() {
        return pajak;
    }

    public double getBiaya() {
        return biaya;
    }

    @Override
    public String toString() {
        return "Pemesanan{" +
                "tglPesan='" + tglPesan + '\'' +
                ", desPesan='" + desPesan + '\'' +
                ", jasa='" + jasa + '\'' +
                ", pajak=" + pajak +
                ", biaya=" + biaya +
                '}';
    }
}

