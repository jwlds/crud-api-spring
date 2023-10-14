package br.com.jw.crudappauth.domain.product;

import br.com.jw.crudappauth.dtos.ProductDTO;
import br.com.jw.crudappauth.domain.review.Review;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class  Product {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private String category;
    private String description;
    private String code;
    private int quantityInStock;
    private Instant createdAt;
    private List<String> images;

    @DocumentReference
    private List<Review> reviewIds;

    public Product(ProductDTO payload, Instant createdAt, List<Review> reviewIds) {
        this.name = payload.name();
        this.price = payload.price();
        this.category = payload.category();
        this.description = payload.description();
        this.code = payload.code();
        this.quantityInStock = payload.quantityInStock();
        this.images = payload.images();
        this.createdAt = createdAt;
        this.reviewIds = reviewIds;
    }


}

