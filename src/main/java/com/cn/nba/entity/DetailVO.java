package com.cn.nba.entity;

public class DetailVO {

    private String mchntTradeNo;//订单详情号

    private String orderDate;//交易日期yyyymmdd

    private int orderAmt;//原实际订单的交易金额，单位为分

    private String goodsNm;//原实际订单的商品名称

    private int quantity;//数量


    public String getMchntTradeNo() {
        return mchntTradeNo;
    }

    public void setMchntTradeNo(String mchntTradeNo) {
        this.mchntTradeNo = mchntTradeNo;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(int orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getGoodsNm() {
        return goodsNm;
    }

    public void setGoodsNm(String goodsNm) {
        this.goodsNm = goodsNm;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DetailVO [mchntTradeNo=" + mchntTradeNo + ", orderDate=" + orderDate + ", orderAmt=" + orderAmt + ", goodsNm=" + goodsNm + ", quantity=" + quantity + "]";
    }


}
