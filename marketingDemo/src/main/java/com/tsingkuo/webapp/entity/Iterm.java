package com.tsingkuo.webapp.entity;

public class Iterm {
    private int id;
    private String itermName;
    private int itermPrice;
    private int itermStock;
    private String itermDescription;
    private String itermPicture;

    public Iterm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItermName() {
        return itermName;
    }

    public void setItermName(String itermName) {
        this.itermName = itermName;
    }

    public int getItermPrice() {
        return itermPrice;
    }

    public void setItermPrice(int itermPrice) {
        this.itermPrice = itermPrice;
    }

    public int getItermStock() {
        return itermStock;
    }

    public void setItermStock(int itermStock) {
        this.itermStock = itermStock;
    }

    public String getItermDescription() {
        return itermDescription;
    }

    public void setItermDescription(String itermDescription) {
        this.itermDescription = itermDescription;
    }

    public String getItermPicture() {
        return itermPicture;
    }

    public void setItermPicture(String itermPicture) {
        this.itermPicture = itermPicture;
    }
}
