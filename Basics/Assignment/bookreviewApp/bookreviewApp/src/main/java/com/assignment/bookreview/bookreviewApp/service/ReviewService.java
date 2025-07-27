package com.assignment.bookreview.bookreviewApp.service;

import com.assignment.bookreview.bookreviewApp.model.Review;
import com.assignment.bookreview.bookreviewApp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    public void addReview(Review review) {
        repository.addReview(review);
    }

    public List<Review> getReviewsByBookId(Integer bookId) {
        return repository.getReviewsForBook(bookId);
    }
}