package com.example.assignment;

public class ProductData {

    String pname,Price,Unit,tQuan,cDate,cTime,amount;

    public ProductData(String pname, String price, String unit, String tQuan, String cDate, String cTime,String amount) {
        this.pname = pname;
        this.Price = price;
        this.Unit = unit;
        this.tQuan = tQuan;
        this.cDate = cDate;
        this.cTime = cTime;
        this.amount = amount;

    }

    public String getPname() {
        return pname;
    }

    public String getPrice() {
        return Price;
    }

    public String getUnit() {
        return Unit;
    }

    public String gettQuan() {
        return tQuan;
    }

    public String getcDate() {
        return cDate;
    }

    public String getcTime() {
        return cTime;
    }

    public String getamount() {
        return amount;
    }
}
