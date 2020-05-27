package com.medecard.user.medecard_patient.models;

public class Records {

    private String date;
    private String hosp_location;
    private String doctor_name;
    private String record_type;
    private String record_status;

    public Records() {
    }

    public Records(String date, String hosp_location, String doctor_name, String record_type, String record_status) {
        this.date = date;
        this.hosp_location = hosp_location;
        this.doctor_name = doctor_name;
        this.record_type = record_type;
        this.record_status = record_status;
    }

    // Getter

    public String getDate() {
        return date;
    }

    public String getHosp_location() {
        return hosp_location;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getRecord_type() {
        return record_type;
    }

    public String getRecord_status() {
        return record_status;
    }

    // Setter


    public void setDate(String date) {
        date = date;
    }

    public void setHosp_location(String hosp_location) {
        this.hosp_location = hosp_location;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public void setRecord_status(String record_status) {
        this.record_status = record_status;
    }
}
