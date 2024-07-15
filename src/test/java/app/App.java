package app;

import app.exception.RequestException;
import app.payload.ProductPayload;
import app.service.HttpClient;
import app.service.HttpClientImpl;
import app.service.ProductService;
import app.service.ProductServiceImpl;

public class App {

    public static void main(String[] args) {
        HttpClient httpClient = new HttpClientImpl("http://example.com");
        ProductService productService = new ProductServiceImpl(httpClient);

        ProductPayload productPayload = new ProductPayload("Samsung Galaxy", 399.99);

        try {
            productService.createProduct(productPayload);
            System.out.println("Product created successfully.");
        } catch (RequestException e) {
            System.err.println("Failed to create product: " + e.getMessage());
        }
    }
}
