package pl.samek.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.samek.ProductCatalog.ArrayListProductStorage;
import pl.samek.ProductCatalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("it Works");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog(){
        var catalog = new ProductCatalog(
                new ArrayListProductStorage()
        );

        catalog.createProduct("Nice one 1", "nice one");
        catalog.createProduct("Nice one 2", "nice two");
        catalog.createProduct("Nice one 2", "nice three");

        return catalog;
    }
}
