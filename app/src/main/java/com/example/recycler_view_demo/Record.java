package com.example.recycler_view_demo;

public class Record {
    String disc,amount,date;

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Record(String disc, String amount, String date) {
        this.disc = disc;
        this.amount = amount;
        this.date = date;
    }
}
