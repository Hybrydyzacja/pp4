package pl.azieba.ecommerce;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductCatalogControler {

    private final ProductCatalog productCatalog;

    public ProductCatalogControler(ProductCatalog productCatalog) {

        this.productCatalog = productCatalog;
    }

//    @GetMapping("/api/hello")
//    List<Product> getProducts() {
//        return productCatalog.findAllProducts();
//    }

    @GetMapping("/api/products")
    List<Product> getAllProducts() {
        return productCatalog.allProducts();

    }

}
