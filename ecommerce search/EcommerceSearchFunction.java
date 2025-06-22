import java.util.*;

class Product {
    private String id;
    private String name;
    private String category;
    private double price;
    private String brand;
    private double rating;
    private int stock;

    public Product(String id, String name, String category, double price, String brand, double rating, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.rating = rating;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public double getRating() { return rating; }
    public int getStock() { return stock; }

    public String toString() {
        return name + " (" + category + ") - Rs." + price + " [" + brand + ", " + rating + " stars, " + stock + " left]";
    }
}

class SearchFilter {
    public String category;
    public Double minPrice;
    public Double maxPrice;
    public String brand;
    public Double minRating;
    public String sortBy = "name";
    public boolean ascending = true;
}

class EcommerceSearchEngine {
    private Product[] products;
    private int productCount;

    public EcommerceSearchEngine() {
        products = new Product[8];
        productCount = 0;
        addProducts();
    }

    private void addProducts() {
        products[productCount++] = new Product("1", "iPhone 15", "Electronics", 82999.0, "Apple", 4.5, 50);
        products[productCount++] = new Product("2", "Galaxy S24", "Electronics", 74999.0, "Samsung", 4.3, 30);
        products[productCount++] = new Product("3", "Air Max", "Footwear", 10999.0, "Nike", 4.2, 100);
        products[productCount++] = new Product("4", "Ultraboost", "Footwear", 12499.0, "Adidas", 4.4, 75);
        products[productCount++] = new Product("5", "MacBook Pro", "Electronics", 169999.0, "Apple", 4.7, 20);
        products[productCount++] = new Product("6", "XPS 13", "Electronics", 109999.0, "Dell", 4.1, 40);
        products[productCount++] = new Product("7", "Levi's Jeans", "Clothing", 6499.0, "Levi's", 4.0, 200);
        products[productCount++] = new Product("8", "H&M Tee", "Clothing", 1499.0, "H&M", 3.8, 300);
    }

    public Product[] search(String query, SearchFilter filter) {
        Product[] temp = new Product[products.length];
        int count = 0;
        for (int i = 0; i < productCount; i++) {
            Product p = products[i];
            if (query != null && !query.equals("")) {
                String q = query.toLowerCase();
                if (!(p.getName().toLowerCase().contains(q) || p.getBrand().toLowerCase().contains(q) || p.getCategory().toLowerCase().contains(q))) {
                    continue;
                }
            }
            if (filter != null) {
                if (filter.category != null && !p.getCategory().equalsIgnoreCase(filter.category)) continue;
                if (filter.minPrice != null && p.getPrice() < filter.minPrice) continue;
                if (filter.maxPrice != null && p.getPrice() > filter.maxPrice) continue;
                if (filter.brand != null && !p.getBrand().equalsIgnoreCase(filter.brand)) continue;
                if (filter.minRating != null && p.getRating() < filter.minRating) continue;
            }
            temp[count++] = p;
        }
        // Simple bubble sort for demonstration
        if (filter != null && filter.sortBy != null) {
            for (int i = 0; i < count - 1; i++) {
                for (int j = 0; j < count - i - 1; j++) {
                    boolean swap = false;
                    if (filter.sortBy.equalsIgnoreCase("price")) {
                        if (filter.ascending) {
                            if (temp[j].getPrice() > temp[j+1].getPrice()) swap = true;
                        } else {
                            if (temp[j].getPrice() < temp[j+1].getPrice()) swap = true;
                        }
                    } else if (filter.sortBy.equalsIgnoreCase("rating")) {
                        if (filter.ascending) {
                            if (temp[j].getRating() > temp[j+1].getRating()) swap = true;
                        } else {
                            if (temp[j].getRating() < temp[j+1].getRating()) swap = true;
                        }
                    } else {
                        if (filter.ascending) {
                            if (temp[j].getName().compareTo(temp[j+1].getName()) > 0) swap = true;
                        } else {
                            if (temp[j].getName().compareTo(temp[j+1].getName()) < 0) swap = true;
                        }
                    }
                    if (swap) {
                        Product t = temp[j];
                        temp[j] = temp[j+1];
                        temp[j+1] = t;
                    }
                }
            }
        }
        Product[] result = new Product[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}

public class EcommerceSearchFunction {
    public static void main(String[] args) {
        EcommerceSearchEngine engine = new EcommerceSearchEngine();
        SearchFilter filter = new SearchFilter();
        filter.category = "Electronics";
        filter.minPrice = 900.0;
        filter.sortBy = "price";
        filter.ascending = true;

        Product[] results = engine.search("", filter);
        System.out.println("Search Results:");
        for (Product p : results) {
            System.out.println(p);
        }
    }
}
