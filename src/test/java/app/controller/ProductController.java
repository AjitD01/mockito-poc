
package app.controller;

import app.exception.RequestException;
import app.payload.ProductPayload;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/v1/products")
    public ResponseEntity<String> createProduct(@RequestBody ProductPayload productPayload) {
        try {
            productService.createProduct(productPayload);
            return ResponseEntity.ok("Product created successfully.");
        } catch (RequestException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create product: " + e.getMessage());
        }
    }
}
