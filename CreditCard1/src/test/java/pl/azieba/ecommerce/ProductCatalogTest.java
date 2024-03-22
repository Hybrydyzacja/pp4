package pl.azieba.ecommerce;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class ProductCatalogTest {

    @Test
    void itAllowsToListAvailableProducts() {
        ProductCatalog catalog = new ProductCatalog();

        List<Product> products = catalog.allProducts();

        assertThat(products).hasSize(0);

    }
}
