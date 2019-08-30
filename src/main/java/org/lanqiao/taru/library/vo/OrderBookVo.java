package org.lanqiao.taru.library.vo;

import org.lanqiao.taru.library.model.Book;

import java.util.List;

public class OrderBookVo {
    private String orderId;
    private List<Book> book;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
