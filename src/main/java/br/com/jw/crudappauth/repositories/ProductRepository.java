package br.com.jw.crudappauth.repositories;

import br.com.jw.crudappauth.domain.product.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Optional<Product> findProductByCode(String code);

    void  deleteByCode(String code);
}
