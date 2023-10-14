package br.com.jw.crudappauth.controllers;


import br.com.jw.crudappauth.domain.product.Product;
import br.com.jw.crudappauth.dtos.ProductDTO;
import br.com.jw.crudappauth.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.allProducts(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable String code){
        return new ResponseEntity<Optional<Product>>(productService.singleProduct(code), HttpStatus.OK);
    }


    @DeleteMapping("/deleteAll")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllProducts() { productService.deleteAllProducts(); }

    @DeleteMapping("/delete/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String code){
        productService.deleteProduct(code);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO payload) {
        return new ResponseEntity<Product>(productService.createProduct(payload), HttpStatus.OK);
    }

}
