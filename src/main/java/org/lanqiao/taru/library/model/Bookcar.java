package org.lanqiao.taru.library.model;

public class Bookcar {
    private String bookcarId;
    private String bookcarBookId;
    private String bookcarUserId;
    private String bookcarBorrowTime;
    private String bookcarStatus;
    private Book book;

    public String getBookcarId() {
        return bookcarId;
    }

    public void setBookcarId(String bookcarId) {
        this.bookcarId = bookcarId;
    }

    public String getBookcarBookId() {
        return bookcarBookId;
    }

    public void setBookcarBookId(String bookcarBookId) {
        this.bookcarBookId = bookcarBookId;
    }

    public String getBookcarUserId() {
        return bookcarUserId;
    }

    public void setBookcarUserId(String bookcarUserId) {
        this.bookcarUserId = bookcarUserId;
    }

    public String getBookcarBorrowTime() {
        return bookcarBorrowTime;
    }

    public void setBookcarBorrowTime(String bookcarBorrowTime) {
        this.bookcarBorrowTime = bookcarBorrowTime;
    }

    public String getBookcarStatus() {
        return bookcarStatus;
    }

    public void setBookcarStatus(String bookcarStatus) {
        this.bookcarStatus = bookcarStatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
