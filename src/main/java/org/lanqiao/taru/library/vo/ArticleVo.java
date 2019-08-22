package org.lanqiao.taru.library.vo;

/**
 *     String articleTitle: 章节名称
 *     String articleBody; 章节的内容
 *     String articleId;  章节id
 *     String articleNum; 当前章节是第几章
 *     String articleBookId ;图书id
 */
public class ArticleVo {

        String articleTitle;
        String articleBody;
        String articleId;
        String articleNum;
        String articleBookId ;

        public String getArticleBookId() {
            return articleBookId;
        }

        public void setArticleBookId(String articleBookId) {
            this.articleBookId = articleBookId;
        }

        public String getArticleTitle() {
            return articleTitle;
        }

        public void setArticleTitle(String articleTitle) {
            this.articleTitle = articleTitle;
        }

        public String getArticleBody() {
            return articleBody;
        }

        public void setArticleBody(String articleBody) {
            this.articleBody = articleBody;
        }



        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public String getArticleNum() {
            return articleNum;
        }

        public void setArticleNum(String articleNum) {
            this.articleNum = articleNum;
        }
}
