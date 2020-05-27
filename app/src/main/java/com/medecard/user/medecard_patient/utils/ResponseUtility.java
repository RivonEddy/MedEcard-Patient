package com.medecard.user.medecard_patient.utils;

import org.json.JSONException;
import org.json.JSONObject;

import static xdroid.core.Global.getContext;

public class ResponseUtility {
    public static boolean isSuccessful(String response){
        try {
            System.out.println("========================= REQUEST RESPONSE ========================= " + response);
            JSONObject resObj = new JSONObject(response);
            String status = resObj.getString("status");
            if(status.contains("success")){
                return true;
            }
            else{
                if(response.contains("token parameter") || response.contains("not authorized")){
                    User user = new User(getContext());
                    //user.logOut();
                }
                return false;
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
            return false;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

//    public static String getMessage(String response){
//        try {
//            JSONObject resObj = new JSONObject(response);
//            String message = resObj.getString("message");
//            return message;
//        }
//        catch (JSONException e) {
//            return "A temporary server error occurred.";
//        }catch (Exception e) {
//            return "A temporary server error occurred.";
//        }
//    }

    public static String getData(String response){
        try {
            JSONObject resObj = new JSONObject(response);
            return resObj.getString("data");
        } catch (JSONException e) {
            return "A server error occurred.";
        }
    }
}