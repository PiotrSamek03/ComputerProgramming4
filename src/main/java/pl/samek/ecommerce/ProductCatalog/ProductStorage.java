package pl.samek.ecommerce.ProductCatalog;

import java.util.List;

public interface ProductStorage {
    List<Product> allProducts();

    void save(Product newProduct);

    Product loadProductById(String productId);
}
