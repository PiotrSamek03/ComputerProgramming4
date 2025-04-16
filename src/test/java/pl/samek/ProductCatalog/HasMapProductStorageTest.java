package pl.samek.ProductCatalog;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HasMapProductStorageTest {

    @Test
    void itSaveAndLoadProduct(){
        Product product = thereIsProduct();
        ProductStorage storage = thereIsStorage();

        storage.save(product);

        var loaded = storage.loadProductById(product.getId());

        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getDescription(), loaded.getDescription());
    }

    private Product thereIsProduct() {
        return new Product(UUID.randomUUID(),"there is", "whatever");
    }

    private ProductStorage thereIsStorage() {
        return HashMapProductStorage();
    }

    private ProductStorage HashMapProductStorage() {
        return null;
    }

    @Test
    void idLoadsAllProducts(){
        Product product = thereIsProduct();
        ProductStorage storage = thereIsStorage();

        storage.save(product);
        List<Product> all = storage.allProducts();
        assertEquals(1, all.size());
    }
}
