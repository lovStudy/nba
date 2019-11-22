package com.cn.nba.entity;

import java.util.List;

public class FuyouRequest {

    private String orderId;//商户购汇订单号

    private String feeType;//标价币种

    private int totalFee;//订单总金额

    private String orderType;//贸易类型

    private String custType;//付款人类型

    private String custNm;//付款人名称

    private String custId;//付款人证件号


    private List<DetailVO> list;//交易明细列表


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }


    public List<DetailVO> getList() {
        return list;
    }

    public void setList(List<DetailVO> list) {
        this.list = list;
    }


}
