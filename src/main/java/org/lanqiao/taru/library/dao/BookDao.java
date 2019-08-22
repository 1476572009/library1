package org.lanqiao.taru.library.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.model.Review;
import org.lanqiao.taru.library.vo.ArticleVo;

import java.util.List;
@Mapper
public interface BookDao {
    // 查询图书列表
    public List<Book> queryList();

    /**
     * 多条件查询
     * @param bookName 根据书名
     * @param bookAuthor 根据作者名
     *二者随意组合 可空
     * @return
     */
    public List<Book> queryByterm(@Param("bookName") String bookName, @Param("bookAuthor") String bookAuthor);
    //  查询榜单
    public List queryBytop();

    /**
     * 查询图书详情
     * @param bookId 根据图书id查询图书信息
     * @return
     */
    public Book queryDetail(String bookId);

    /**
     * 图书预览
     * @param articleBookId
     * @param articleId
     * @return
     */
    public ArticleVo review(@Param("articleBookId") String articleBookId,@Param("articleId") String articleId );
}