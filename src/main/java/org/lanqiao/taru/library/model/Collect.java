package org.lanqiao.taru.library.model;

public class Collect {
    private String collectId;
    private String collectUserId;
    private String collectBookId;
    private String collectTime;
    private String collectStatus;
    private Book book;

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public String getCollectUserId() {
        return collectUserId;
    }

    public void setCollectUserId(String collectUserId) {
        this.collectUserId = collectUserId;
    }

    public String getCollectBookId() {
        return collectBookId;
    }

    public void setCollectBookId(String collectBookId) {
        this.collectBookId = collectBookId;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
