package com.example.assignment;

public class ListItem {

    private String pname;
    private String price;
    private String cTime;
    private String cDate;
    private String tQuan;
    private String amount;
    private String unit;

    public ListItem(String pname, String price, String cTime, String cDate, String tQuan,  String amount, String unit) {
        this.pname = pname;
        this.price = price;
        this.cTime = cTime;
        this.cDate = cDate;
        this.tQuan = tQuan;
        this.amount = amount;
        this.unit = unit;
    }

    public String getPname() {
        return pname;
    }

    public String getPrice() {
        return price;
    }


    public String getcTime() {
        return cTime;
    }

    public String getcDate() {
        return cDate;
    }

    public String gettQuan() {
        return tQuan;
    }

    public String getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }


}
