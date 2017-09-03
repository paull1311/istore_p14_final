package edu.bionic;

public class IStoreApplication {

//    private static List<Operation> products;
//
//    public static void main(String[] args) {
//        initProducts();
//
//        List<Operation> sortedProducts = getSortedProducts();
//        printProducts(sortedProducts);
//    }
//
//    private static void initProducts() {
//        products = ImmutableList.of(
//                new Operation(1, "iPhone 7", 700),
//                new Operation(2, "iPhone 7 Plus", 800),
//                new Operation(3, "MacBook Pro", 1500)
//        );
//    }
//
//    private static List<Operation> getSortedProducts() {
//        return products
//                .stream()
//                .sorted((product1, product2) -> Double.compare(product2.getPrice(), product1.getPrice()))
//                .collect(Collectors.toList());
//    }
//
//    private static void printProducts(List<Operation> products) {
//        products.forEach(product -> {
//            System.out.println(String.format("Operation: %s, price - %.2f USD", product.getName(), product.getPrice()));
//        });
//    }
}
