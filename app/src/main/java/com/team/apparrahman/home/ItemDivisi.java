package com.team.apparrahman.home;

public class ItemDivisi {

    private String tlDivisi;
    private String dsDivisi;
    private boolean expDivisi;

    public ItemDivisi(String tlDivisi, String dsDivisi) {
        this.tlDivisi = tlDivisi;
        this.dsDivisi = dsDivisi;
        this.expDivisi = false;
    }

    public String getTlDivisi() {
        return tlDivisi;
    }

    public void setTlDivisi(String tlDivisi) {
        this.tlDivisi = tlDivisi;
    }

    public String getDsDivisi() {
        return dsDivisi;
    }

    public void setDsDivisi(String dsDivisi) {
        this.dsDivisi = dsDivisi;
    }

    public boolean isExpDivisi() {
        return expDivisi;
    }

    public void setExpDivisi(boolean expDivisi) {
        this.expDivisi = expDivisi;
    }

    public String toString(){
        return "Divisi{"+
                ", deskripsi='"+ dsDivisi + '\'' +
                ", expanded=" + expDivisi + '}';
    }
}
