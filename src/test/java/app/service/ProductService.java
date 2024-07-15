package app.service;

import app.domain.Product;
import app.payload.ProductPayload;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
  Product createProduct(@NonNull ProductPayload payload);

}
