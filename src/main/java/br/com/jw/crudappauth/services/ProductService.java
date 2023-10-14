package br.com.jw.crudappauth.services;
import br.com.jw.crudappauth.domain.product.Product;
import br.com.jw.crudappauth.domain.review.Review;
import br.com.jw.crudappauth.dtos.ProductDTO;
import br.com.jw.crudappauth.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> allProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> singleProduct(String code){
        return productRepository.findProductByCode(code);
    }


    public void deleteProduct(String code){ productRepository.deleteByCode(code);}

    public void deleteAllProducts() { productRepository.deleteAll(); }
    public Product createProduct(ProductDTO product){
        List<Review> reviewsIds = new ArrayList<Review>();
        Instant createdAt = Instant.now();
        return productRepository.insert(new Product(product,createdAt,reviewsIds));
    }



}
