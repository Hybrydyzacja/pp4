package pl.azieba.ecommerce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.azieba.ecommerce.ArrayListProductStorage;
import pl.azieba.ecommerce.ProductCatalog;

import java.math.BigDecimal;


@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Here we go!!!");
        SpringBootApplication.run(App.class, args);
    }


    @Bean
    ProductCatalog createMyProductCatalog() {
        var catalog = new ProductCatalog(new ArrayListProductStorage());
        var pid1 = catalog.addProduct("Lego set 883", "Nice one");
        catalog.changePrice(pid1, BigDecimal.valueOf(10,10));

        var pid2 = catalog.addProduct("Cobi set 883", "Nice one");
        catalog.changePrice(pid2, BigDecimal.valueOf(50,10));

        return catalog;
    }

}
