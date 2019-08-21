package org.lanqiao.taru.library.service;

import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.vo.ArticleVo;

import java.util.List;

public interface BookService {
//    查询图书列表
    public List<Book> queryList();
//    多条件查询图书
    public List<Book> queryByterm(String bookName,String bookAuthor);

//  查询榜单
    public List queryBytop();

    // 查询图书详情
    public Book queryDetail(String bookId);

    /**
     * 图书预览
     * @param articleBookId
     * @param articleId
     * @return
     */
    public ArticleVo review(String articleBookId, String articleId ) ;
}
