package br.com.jw.crudappauth.services;



import br.com.jw.crudappauth.domain.product.Product;
import br.com.jw.crudappauth.domain.review.Review;
import br.com.jw.crudappauth.dtos.ReviewDTO;
import br.com.jw.crudappauth.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(ReviewDTO payload) {
        Review review = reviewRepository.insert(new Review(payload));

        mongoTemplate.update(Product.class)
                .matching(Criteria.where("code").is(payload.code()))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
