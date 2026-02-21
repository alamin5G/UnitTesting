package product_store_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prodcut_store.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("Product Test Suite")
public class ProductTest {

    @Test
    @DisplayName("Test Product Creation: Should Create Product with Correct Attributes")
    public void testProductCreation() {
        // Arrange
        String expectedSKU = "PROD001";
        String expectedName = "Test Product";
        double expectedPrice = 19.99;
        int expectedQuantity = 100;

        // Act
        Product product = new Product(expectedSKU, expectedName, expectedPrice, expectedQuantity);

        // Assert
        assertEquals(expectedSKU, product.getSKU());
        assertEquals(expectedName, product.getName());
        assertEquals(expectedPrice, product.getPrice());
        assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test
    @DisplayName("Test Product Default Constructor: Should Create Product with Default Values")
    public void testProductDefaultConstructor() {
        // Arrange
        String expectedSKU = null;
        String expectedName = null;
        double expectedPrice = 0.0;
        int expectedQuantity = 0;

        // Act
        Product product = new Product();

        // Assert
        assertThrows(NullPointerException.class, () -> product.getSKU().length());
        assertThrows(NullPointerException.class, () -> product.getName().length());
        assertEquals(expectedPrice, product.getPrice());
        assertEquals(expectedQuantity, product.getQuantity());
    }
}
