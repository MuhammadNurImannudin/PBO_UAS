/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Pembayaran {
    private String tglBayar;
    private String jenisBayar;
    private String desBayar;
    private double total;

    // Constructor, getters, setters, and toString method
    public Pembayaran(String tglBayar, String jenisBayar, String desBayar, double total) {
        this.tglBayar = tglBayar;
        this.jenisBayar = jenisBayar;
        this.desBayar = desBayar;
        this.total = total;
    }

    public String getTglBayar() {
        return tglBayar;
    }

    public String getJenisBayar() {
        return jenisBayar;
    }

    public String getDesBayar() {
        return desBayar;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Pembayaran{" +
                "tglBayar='" + tglBayar + '\'' +
                ", jenisBayar='" + jenisBayar + '\'' +
                ", desBayar='" + desBayar + '\'' +
                ", total=" + total +
                '}';
    }
}
