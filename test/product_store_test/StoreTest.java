package product_store_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prodcut_store.Product;
import prodcut_store.Store;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Store Test Suite")
public class StoreTest {

    @Test
    @DisplayName("Test Store Creation: Should Create Store with Correct Attributes")
    public void testStoreCreation() {
        // Arrange
        String expectedName = "Test Store";
        String expectedLocation = "123 Test Street";
        List<Product> expectedProducts = new ArrayList<>();
        // Act
        Store store = new Store(expectedName, expectedLocation);

        // Assert
        assertEquals(expectedName, store.getName());

    }
}
