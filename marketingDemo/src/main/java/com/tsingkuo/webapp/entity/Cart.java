package com.tsingkuo.webapp.entity;

public class Cart {
    private int id;
    private int userId;
    private int itermId;
    private int cartItermAmount;

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItermId() {
        return itermId;
    }

    public void setItermId(int itermId) {
        this.itermId = itermId;
    }

    public int getCartItermAmount() {
        return cartItermAmount;
    }

    public void setCartItermAmount(int cartItermAmount) {
        this.cartItermAmount = cartItermAmount;
    }
}
