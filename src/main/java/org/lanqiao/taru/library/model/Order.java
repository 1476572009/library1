package org.lanqiao.taru.library.model;

import java.util.List;

public class Order {
    private String orderId;
    private String orderUserId;
    private String orderDateTime;
    private String orderIsSend;
    private String orderIsValid;
    private String orderTotalPrice;
    private String orderComment;
    private String orderStatus;
    private List<Borrow> borrows;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getOrderIsSend() {
        return orderIsSend;
    }

    public void setOrderIsSend(String orderIsSend) {
        this.orderIsSend = orderIsSend;
    }

    public String getOrderIsValid() {
        return orderIsValid;
    }

    public void setOrderIsValid(String orderIsValid) {
        this.orderIsValid = orderIsValid;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }
}
