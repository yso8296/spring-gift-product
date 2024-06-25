package gift.controller;

import gift.Product;
import gift.ProductDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final Map<Long, Product> products = new HashMap<>();

    @PostMapping("/api/product")
    public void registerProduct(@RequestBody ProductDTO productDTO) {
        products.put(productDTO.id(), productDTO.toEntity());
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
}