package org.lanqiao.taru.library.vo;

/**
 * 排行榜vo类
 *      int count;数据收藏量
 *     String bookId;书籍id
 *     String booksName;书籍名称
 */
public class TopVo {
    int count;
    String bookId;
    String booksName;
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBooksName() {
        return booksName;
    }

    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }


}
