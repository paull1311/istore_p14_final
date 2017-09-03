package edu.bionic.dao;

import edu.bionic.domain.Operation;
import edu.bionic.testdata.ProductFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OperationDaoTest extends BaseDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void getAll() throws Exception {
        List<Operation> expected = ProductFactory.getAllProducts();
        List<Operation> actual = productDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getById() throws Exception {
        Operation expected = ProductFactory.getProduct1();
        Operation actual = productDao.getById(1).get();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void saveNew() throws Exception {
        Operation newOperation = ProductFactory.newProduct();
        Operation savedOperation = productDao.save(newOperation);
        newOperation.setId(savedOperation.getId());

        List<Operation> expected = ProductFactory.getAllProducts();
        expected.add(newOperation);
        List<Operation> actual = productDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void saveUpdate() throws Exception {
        Operation operationToUpdate = ProductFactory.getProduct2Updated();
        Operation updatedOperation = productDao.save(operationToUpdate);
        Assert.assertEquals(operationToUpdate.toString(), updatedOperation.toString());

        Operation updatedOperationFromDB = productDao.getById(2).get();
        Assert.assertEquals(operationToUpdate.toString(), updatedOperationFromDB.toString());
    }

    @Test
    public void delete() throws Exception {
        boolean isDeleted = productDao.delete(3);
        Assert.assertEquals(isDeleted, true);

        List<Operation> expected = ProductFactory.getAllProducts()
                .stream().filter(product -> product.getId() != 3).collect(Collectors.toList());
        List<Operation> actual = productDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deleteNotFound() throws Exception {
        boolean isDeleted = productDao.delete(1000);
        Assert.assertEquals(isDeleted, false);
    }

    @Test
    public void getAllSortedByName() throws Exception {
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .sorted(Comparator.comparing(Operation::getName))
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByName(null, null, null, false, 0, 1000);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllSortedByNameWithLimits() throws Exception {
        int offset = 2;
        int limit = 3;
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .sorted(Comparator.comparing(Operation::getName))
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByName(null, null, null, false, offset, limit);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllSortedByNameDesc() throws Exception {
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .sorted((p1, p2) -> p2.getName().compareTo(p1.getName()))
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByName(null, null, null, true, 0, 1000);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllFilteredByNameSortedByName() throws Exception {
        String filterName = "Plus";
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .filter(product -> product.getName().contains(filterName))
                .sorted(Comparator.comparing(Operation::getName))
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByName(filterName, null, null, false, 0, 1000);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllFilteredByPriceSortedByName() throws Exception {
        BigDecimal filterMin = BigDecimal.valueOf(650);
        BigDecimal filterMax = BigDecimal.valueOf(700);
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .filter(product -> product.getPrice().compareTo(filterMin) >= 0
                        && product.getPrice().compareTo(filterMax) <= 0)
                .sorted(Comparator.comparing(Operation::getName))
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByName(null, filterMin, filterMax, false, 0, 1000);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllSortedByPrice() throws Exception {
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .sorted(Comparator.comparing(Operation::getPrice))
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByPrice(null, null, null, false, 0, 1000);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllSortedByPriceWithLimits() throws Exception {
        int offset = 2;
        int limit = 3;
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .sorted(Comparator.comparing(Operation::getPrice))
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByPrice(null, null, null, false, offset, limit);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllSortedByPriceDesc() throws Exception {
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByPrice(null, null, null, true, 0, 1000);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllFilteredByNameSortedByPrice() throws Exception {
        String filterName = "Plus";
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .filter(product -> product.getName().contains(filterName))
                .sorted(Comparator.comparing(Operation::getPrice))
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByPrice(filterName, null, null, false, 0, 1000);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAllFilteredByPriceSortedByPrice() throws Exception {
        BigDecimal filterMin = BigDecimal.valueOf(650);
        BigDecimal filterMax = BigDecimal.valueOf(700);
        List<Operation> expected = ProductFactory.getAllProducts()
                .stream()
                .filter(product -> product.getPrice().compareTo(filterMin) >= 0
                        && product.getPrice().compareTo(filterMax) <= 0)
                .sorted(Comparator.comparing(Operation::getPrice))
                .collect(Collectors.toList());

        List<Operation> actual = productDao.getAllSortedByPrice(null, filterMin, filterMax, false, 0, 1000);

        Assert.assertEquals(expected.toString(), actual.toString());
    }
}