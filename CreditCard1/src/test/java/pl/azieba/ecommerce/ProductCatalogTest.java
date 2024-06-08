package pl.azieba.ecommerce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;


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
        String id = catalog.addProduct("Lego set 883", "Nice one");

        Product loaded = catalog.getProductBy(id);

        assertThat(id).isEqualTo(loaded.getId());
    }


    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 883", "Nice one");

        Product loaded = catalog.getProductBy(id);

        assertThat(loaded.getName()).isEqualTo("Lego set 883");

    }

    @Test
    void itChangePriceForProduct() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 883", "Nice one";

        catalog.changePrice(id, BigDecimal.valueOf(10,10));
        Product loaded = catalog.getProductBy(id);

        assertThat(loaded.getPrice()).isEqualTo(BigDecimal.valueOf(10,10));
    }

    private static ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(new ArrayListProductStorage());
    }

}
