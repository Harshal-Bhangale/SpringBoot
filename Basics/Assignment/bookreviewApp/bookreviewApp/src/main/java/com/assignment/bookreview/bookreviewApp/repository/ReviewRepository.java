package com.assignment.bookreview.bookreviewApp.repository;

import com.assignment.bookreview.bookreviewApp.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewRepository {
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review)
    {
        reviews.add(review);
    }
    public List<Review> getReviewsForBook(Integer bookId)
    {
        return  reviews.stream().filter(r -> r.getBookId().equals(bookId)).collect(Collectors.toList());
    }

}

