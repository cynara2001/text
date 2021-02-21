package com.example.keepaccount.database.domain;

public class Account {
    private int id;
    private int sum;
    private String remark;

    public Account() {
    }

    public Account(int sum, String remark) {
        this.sum = sum;
        this.remark = remark;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
