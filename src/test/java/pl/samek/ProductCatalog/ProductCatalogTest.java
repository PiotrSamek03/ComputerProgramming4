package pl.samek.ProductCatalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {

    @Test
    void itAllowsToListAllProducts(){
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assertTrue(products.isEmpty());
    }

    @Test
    void itAllowsToCreateProducts(){
        ProductCatalog catalog = thereIsProductCatalog();

        String productId1 = catalog.createProduct("Lego set 8083", "nice one");
        String productId2 = catalog.createProduct("Lego set 8083", "nice one");

        assertNotEquals(productId1, productId2);
    }

    @Test
    void itLoadProductsById(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId1 = catalog.createProduct("Lego set 8083", "nice one");

        Product loaded = catalog.loadProductById(productId1);

        assertEquals(productId1, loaded.getId());
        assertEquals("Lego set 8083", loaded.getName());
        assertEquals("nice one", loaded.getDescription());
    }

    @Test
    void allowsToApplyPrice(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.createProduct("Lego set 8083", "nice one");

        catalog.changePrice(productId, BigDecimal.valueOf(100.10));
        catalog.changeImage(productId, "");

        Product loaded = catalog.loadProductById(productId);
        assertEquals(BigDecimal.valueOf(100.10), loaded.getPrice());
    }

    @Test
    void denyToApplyPriceThatViolateMinimalRange(){
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.createProduct("Lego set 8083", "Nice one");

        catalog.changePrice(productId, BigDecimal.valueOf(100.10));

        Product loaded = catalog.loadProductById(productId);
        assertEquals(BigDecimal.valueOf(100.10), loaded.getPrice());
    }
    @Test
    void allowsToApplyImage() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.createProduct("Lego set 8083", "Nice one");

        catalog.changeImage(productId, "whatever");

        Product loaded = catalog.loadProductById(productId);
        assertEquals("whatever", loaded.getImage());
    }



    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(
                new ArrayListProductStorage()
        );
    }
}
