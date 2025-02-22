package com.example.ilocanospeech_to_texttranslatorapp.model;

public class RecyclerModel {

    private String date;
    private String time;
    private String english_text;
    private String ilocano_text;

    public RecyclerModel(String date, String time, String english_text, String ilocano_text){
        this.date = date;
        this.time = time;
        this.english_text = english_text;
        this.ilocano_text = ilocano_text;
    }

    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getEnglish_text(){
        return english_text;
    }
    public String getIlocano_text(){
        return ilocano_text;
    }
}
