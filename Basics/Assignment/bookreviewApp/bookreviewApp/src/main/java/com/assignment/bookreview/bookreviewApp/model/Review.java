package com.assignment.bookreview.bookreviewApp.model;

import java.net.Inet4Address;

public class Review {
    private Integer id;
    private Integer bookId;
    private String reviewer;
    private  String comment;

    public Review(){}

    public Review(Integer id, Integer bookId, String reviewer, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.reviewer = reviewer;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getReviewer() {
        return reviewer;
    }
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", reviewer='" + reviewer + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
