package com.medecard.user.medecard_patient.models;

public class Sharing {

    private int doc_pic;
    private String doc_name;
    private String hosp_address;
    private String date;
    private int exp_btn;

    public Sharing() {
    }

    public Sharing(int doc_pic, String doc_name, String hosp_address, String date, int exp_btn) {
        this.doc_pic = doc_pic;
        this.doc_name = doc_name;
        this.hosp_address = hosp_address;
        this.date = date;
        this.exp_btn = exp_btn;
    }

    public int getDoc_pic() {
        return doc_pic;
    }

    public void setDoc_pic(int doc_pic) {
        this.doc_pic = doc_pic;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getHosp_address() {
        return hosp_address;
    }

    public void setHosp_address(String hosp_address) {
        this.hosp_address = hosp_address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getExp_btn() {
        return exp_btn;
    }

    public void setExp_btn(int exp_btn) {
        this.exp_btn = exp_btn;
    }
}
