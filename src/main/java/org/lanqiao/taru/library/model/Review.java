package org.lanqiao.taru.library.model;

import java.util.List;

public class Review {

    private String reviewId;
    private String reviewUserId;
    private String reviewBookId;
    private String reviewComment;
    private String reviewFatherId;
    private String reviewStatus;
    private List<Review> reviews;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(String reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public String getReviewBookId() {
        return reviewBookId;
    }

    public void setReviewBookId(String reviewBookId) {
        this.reviewBookId = reviewBookId;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public String getReviewFatherId() {
        return reviewFatherId;
    }

    public void setReviewFatherId(String reviewFatherId) {
        this.reviewFatherId = reviewFatherId;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
