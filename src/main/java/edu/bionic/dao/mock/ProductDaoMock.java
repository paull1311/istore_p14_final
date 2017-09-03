package edu.bionic.dao.mock;

import edu.bionic.dao.ProductDao;
import edu.bionic.domain.Color;
import edu.bionic.domain.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoMock implements ProductDao {

    private List<Operation> operationStorage;


    @Override
    public List<Operation> getAll() {
        return new ArrayList<>(operationStorage);
    }

    @Override
    public List<Operation> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        return null;
    }

    @Override
    public List<Operation> getAllSortedByPrice(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        return null;
    }

    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max) {
        return operationStorage.size();
    }

    @Override
    public Optional<Operation> getById(int productId) {
        return operationStorage.stream().filter(product -> product.getId() == productId).findAny();
    }

    @Override
    public Operation save(Operation operation) {
        return null;
    }

    @Override
    public boolean delete(int productId) {
        return false;
    }

    public void initProductStorage() {
        operationStorage = new ArrayList<>();

        operationStorage.add(new Operation(
                1,
                "iPhone 7",
                BigDecimal.valueOf(700),
                Color.BLACK,
                64,
                "4,7 inch",
                null
        ));
        operationStorage.add(new Operation(
                2,
                "iPhone 7",
                BigDecimal.valueOf(700),
                Color.WHITE,
                128,
                "4,7 inch",
                null
        ));
        operationStorage.add(new Operation(
                3,
                "iPhone 7",
                BigDecimal.valueOf(700),
                Color.GRAY,
                256,
                "4,7 inch",
                null
        ));
        operationStorage.add(new Operation(
                4,
                "iPhone 7 Plus",
                BigDecimal.valueOf(800),
                Color.BLACK,
                256,
                "5,5 inch",
                null
        ));
        operationStorage.add(new Operation(
                5,
                "iPhone 7 Plus",
                BigDecimal.valueOf(800),
                Color.GRAY,
                64,
                "5,5 inch",
                null
        ));
        operationStorage.add(new Operation(
                6,
                "iPhone 7 Plus",
                BigDecimal.valueOf(800),
                Color.WHITE,
                128,
                "5,5 inch",
                null
        ));
    }
}
