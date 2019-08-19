package org.lanqiao.taru.library.model;

public class Borrow {
    private String borrowId;
    private String borrowUserId;
    private String borrowBookId;
    private String borrowBookNumber;
    private String borrowBookBorrowDate;
    private String borrowBookReturnDate;
    private String borrowBookTotalPrice;
    private String borrowBookIsReturn;
    private String borrowOrderId;
    private String borrowStatus;
    private Book book;

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(String borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public String getBorrowBookId() {
        return borrowBookId;
    }

    public void setBorrowBookId(String borrowBookId) {
        this.borrowBookId = borrowBookId;
    }

    public String getBorrowBookNumber() {
        return borrowBookNumber;
    }

    public void setBorrowBookNumber(String borrowBookNumber) {
        this.borrowBookNumber = borrowBookNumber;
    }

    public String getBorrowBookBorrowDate() {
        return borrowBookBorrowDate;
    }

    public void setBorrowBookBorrowDate(String borrowBookBorrowDate) {
        this.borrowBookBorrowDate = borrowBookBorrowDate;
    }

    public String getBorrowBookReturnDate() {
        return borrowBookReturnDate;
    }

    public void setBorrowBookReturnDate(String borrowBookReturnDate) {
        this.borrowBookReturnDate = borrowBookReturnDate;
    }

    public String getBorrowBookTotalPrice() {
        return borrowBookTotalPrice;
    }

    public void setBorrowBookTotalPrice(String borrowBookTotalPrice) {
        this.borrowBookTotalPrice = borrowBookTotalPrice;
    }

    public String getBorrowBookIsReturn() {
        return borrowBookIsReturn;
    }

    public void setBorrowBookIsReturn(String borrowBookIsReturn) {
        this.borrowBookIsReturn = borrowBookIsReturn;
    }

    public String getBorrowOrderId() {
        return borrowOrderId;
    }

    public void setBorrowOrderId(String borrowOrderId) {
        this.borrowOrderId = borrowOrderId;
    }

    public String getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
