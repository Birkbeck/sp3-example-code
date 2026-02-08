package demothree;

public class AppConfig {
    public static void main(String[] args) {
        ProductRepository productRepository = new SqlProductRepository();
        ProductRepository testRepo = new InMemoryProductRepository();
        ProductRepository hashedRepo = new HashedProductRepository();

        ProductService productService = new ProductService(productRepository);
        productService.displayProduct(1);
        productService = new ProductService(hashedRepo);
        productService.displayProduct(1);
    }
}

interface ProductRepository {
    String findProductById(int id);
    int findProductByName(String name);
}

class SqlProductRepository implements ProductRepository {
    public String findProductById(int id) {
        return "Product " + id + " : " + getClass().getName();
    }
    public int findProductByName(String name) {
        return 1;
    }
}

class InMemoryProductRepository implements ProductRepository {
    public String findProductById(int id) {
        return "Product " + id + " : " + getClass().getName();
    }
    public int findProductByName(String name) {
        return 99;
    }
}

class HashedProductRepository implements ProductRepository {
    public String findProductById(int id) {
        return "Product " + id + " : " + getClass().getName();
    }
    public int findProductByName(String name) {
        return 57;
    }
}

class ProductService {
    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository) { // DI via constructor
        this.productRepository = productRepository;
    }

    public void displayProduct(int id) {
        System.out.println(productRepository.findProductById(id));
        System.out.println(productRepository.findProductByName("Product 1"));
    }
}