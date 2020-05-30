package com.medecard.user.medecard_patient.models;

public class ScreenItem {

    String Title, Desctiption;
    int ScreenImg;

    public ScreenItem(String title, String desctiption, int screenImg) {
        Title = title;
        Desctiption = desctiption;
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return Title;
    }

    public String getDesctiption() {
        return Desctiption;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDesctiption(String desctiption) {
        Desctiption = desctiption;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }
}
