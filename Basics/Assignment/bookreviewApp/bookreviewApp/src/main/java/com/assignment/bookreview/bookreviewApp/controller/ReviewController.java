package com.assignment.bookreview.bookreviewApp.controller;


import com.assignment.bookreview.bookreviewApp.model.Review;
import com.assignment.bookreview.bookreviewApp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books/{bookId}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public ResponseEntity<String> addReview(
            @PathVariable Integer bookId,
            @RequestBody Review review) {

        review.setBookId(bookId);
        service.addReview(review);
        return ResponseEntity.ok("Review added!");
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(@PathVariable Integer bookId) {
        return ResponseEntity.ok(service.getReviewsByBookId(bookId));
    }
}