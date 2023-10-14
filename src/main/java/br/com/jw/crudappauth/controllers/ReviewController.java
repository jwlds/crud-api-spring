package br.com.jw.crudappauth.controllers;


import br.com.jw.crudappauth.domain.review.Review;
import br.com.jw.crudappauth.dtos.ReviewDTO;
import br.com.jw.crudappauth.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload),
                HttpStatus
                .OK);
    }
}
