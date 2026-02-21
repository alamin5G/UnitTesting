package prodcut_store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private String location;
    private List<Product> products;


    public Store(String name, String location){
        this.name = name;
        this.location = location;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        if(product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if(product.getQuantity() <= 0){
            throw new IllegalArgumentException("Product quantity cannot be less than zero or zero.");
        }


/*
        if (products.Any(p => p.SKU == product.SKU))
        {
            var existingProduct = products.First(p => p.SKU == product.SKU);
            if (existingProduct.Name != product.Name)
            {
                throw new InvalidOperationException("A product with the same SKU but a different name already exists.");
            }
            existingProduct.Quantity += product.Quantity;
        }
        else
        {
            products.Add(product);
        }
*/
        if(products.stream().anyMatch(p -> p.getSKU().equals(product.getSKU()))) {

            Product existingProduct = products.stream().filter(p -> p.getSKU().equals(product.getSKU())).findFirst().orElse(null);

            if(existingProduct != null && !existingProduct.getName().equals(product.getName())) {
                throw new IllegalStateException("A product with the same SKU but a different name already exists.");
            }
            if(existingProduct != null) {
                int updatedQuantity = existingProduct.getQuantity() + product.getQuantity();
                products.remove(existingProduct);
                products.add(new Product(existingProduct.getSKU(), existingProduct.getName(), existingProduct.getPrice(), updatedQuantity));
            }
        } else {
            products.add(product);
        }

    }



    public List<Product> getProducts() {
        return products;
    }



    public void removeProduct(Product product){
        if(product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if(!products.contains(product)) {
            throw new IllegalStateException("Product does not exist in the store.");
        }
        products.remove(product);
    }



    public Product getProduct(String SKU){
        if(SKU == null) {
            throw new IllegalArgumentException("SKU cannot be null.");
        }
        return products.stream().filter(p -> p.getSKU().equals(SKU)).findFirst().orElse(null);
    }



    public int getQuantity(String SKU){
        if(SKU == null) {
            throw new IllegalArgumentException("SKU cannot be null.");
        }
        return products.stream().filter(p -> p.getSKU().equals(SKU)).mapToInt(Product::getQuantity).sum();
    }



    public int getTotalProductsCount(){
        return products.size();
    }



    public int getTotalQuantity(){
        if (products.isEmpty()) {
            return 0;
        }
        return products.stream().mapToInt(Product::getQuantity).sum();

    }


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
