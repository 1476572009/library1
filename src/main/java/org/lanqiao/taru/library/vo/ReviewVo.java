package org.lanqiao.taru.library.vo;

import org.lanqiao.taru.library.model.Review;

import java.util.List;

public class ReviewVo {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    String userId;
    String userName;
    String userIcon;
    String reviewComment;
    List<ReviewVo> reviews;
    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ReviewVo> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewVo> reviews) {
        this.reviews = reviews;
    }




}
