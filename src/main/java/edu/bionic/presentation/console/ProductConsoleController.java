package edu.bionic.presentation.console;

import edu.bionic.domain.Operation;
import edu.bionic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductConsoleController {

    private ProductService productService;

    @Autowired
    public ProductConsoleController(ProductService productService) {
        this.productService = productService;
    }

    public void printAllProducts() {
        productService.getAll().forEach(product -> System.out.println(product.printInfo()));
    }

    public void printProductInfo(int productId) {
        Operation operation = productService.getById(productId);

        System.out.println("Наименование: " + operation.getName());
        System.out.println("Цвет: " + operation.getColor());
        System.out.println("Память: " + operation.getCapacity());
        System.out.println("Дисплей: " + operation.getDisplay());
        System.out.println("Цена: " + operation.getPrice());
    }
}
