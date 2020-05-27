package com.medecard.user.medecard_patient.models;

public class HealthTips {

    private int tips_pic;
    private String tips_desc;

    public HealthTips() {
    }

    public HealthTips(int tips_pic, String tips_desc) {
        this.tips_pic = tips_pic;
        this.tips_desc = tips_desc;
    }

    public int getTips_pic() {
        return tips_pic;
    }

    public void setTips_pic(int tips_pic) {
        this.tips_pic = tips_pic;
    }

    public String getTips_desc() {
        return tips_desc;
    }

    public void setTips_desc(String tips_desc) {
        this.tips_desc = tips_desc;
    }
}
