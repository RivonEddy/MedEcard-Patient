package com.medecard.user.medecard_patient.models;

import com.orm.SugarRecord;

public class User extends SugarRecord {

    public int user_id;
    public String sname;
    public String fname;
    public String email;
    public String mobile;
    public String passowrd;
    public String cnfPassword;



}
