package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

public class Offer {
    private int ID;
    private String Series_reference;
    private Date Period;
    private Double Data_value;
    private String Suppressed;
    private String STATUS;
    private String UNITS;
    private int Magnitude;
    private String Subject;
    private String Group;
    private String Series_title_1;
    private String Series_title_2;
    private String Series_title_3;
    private String Series_title_4;
    private String Series_title_5;

    Offer(String offer, int ID) throws ParseException {
        String[] subs = offer.split(",");
        this.ID = ID;
        Series_reference = subs[0];
        if (!subs[1].equals("")) {
            String date = subs[1].substring(0, 4) + "-" + subs[1].substring(5) + "-00";
            Period = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }
        else{
            Period = null;
        }
        if (!subs[2].equals(""))
            Data_value = Double.parseDouble(subs[2]);
        else
            Data_value = 0.0;
        Suppressed = subs[3];
        STATUS = subs[4];
        UNITS = subs[5];
        Magnitude = Integer.parseInt(subs[6]);
        Subject = subs[7];
        Group = subs[8];
        Series_title_1 = subs[9];
        Series_title_2 = subs[10];
        /*Series_title_3 = subs[11];
        Series_title_4 = subs[12];
        Series_title_5 = subs[13];*/
    }
    public int getID(){
        return ID;
    }

    public String getSeries_reference() {
        return Series_reference;
    }

    public Date getPeriod() {
        return Period;
    }

    public Double getData_value() {
        return Data_value;
    }

    public String getSuppressed() {
        return Suppressed;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public String getUNITS() {
        return UNITS;
    }

    public int getMagnitude() {
        return Magnitude;
    }

    public String getSubject() {
        return Subject;
    }

    public String getGroup() {
        return Group;
    }

    public String getSeries_title_1() {
        return Series_title_1;
    }

    public String getSeries_title_2() {
        return Series_title_2;
    }

    public String getSeries_title_3() {
        return Series_title_3;
    }

    public String getSeries_title_4() {
        return Series_title_4;
    }

    public String getSeries_title_5() {
        return Series_title_5;
    }
}
