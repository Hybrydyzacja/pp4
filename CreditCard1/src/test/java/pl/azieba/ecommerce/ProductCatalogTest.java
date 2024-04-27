package pl.azieba.ecommerce;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class ProductCatalogTest {

    @Test
    void itAllowsToListAvailableProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assertThat(products).hasSize(0);
    }

    private ProductCatalog thereIsProductCatalog() {
        ProductCatalog catalog = new ProductCatalog();
        return catalog;
    }

    @Test
    void itAllowsToLoadProducts() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.createProduct("Lego set 883");
    }


    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.createProduct("");

        Product loaded = catalog.getProductDetails(id);

        assertThat(loaded.getName()).isEqualTo("Lego set 883");

    }

    @Test
    void itChangePriceForProduct() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.createProduct("Lego set 883");

        catalog.changePrice(id, BigDecimal.valueOf(10,10));
        Product loaded = catalog.getProductDetails(id);

        assertThat(loaded.getPrice()).isEqualTo(BigDecimal.valueOf(10,10));
    }
}
