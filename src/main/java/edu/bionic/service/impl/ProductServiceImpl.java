package edu.bionic.service.impl;

import edu.bionic.dao.ProductDao;
import edu.bionic.domain.Operation;
import edu.bionic.dto.OperationSort;
import edu.bionic.service.ProductService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Operation> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Operation> getAll(String name, BigDecimal min, BigDecimal max, OperationSort operationSort, int offset, int limit) {
        List<Operation> result = new ArrayList<>();
        switch (operationSort) {
            case NAME_ASC:
            case NAME_DESC:
                result = this.productDao.getAllSortedByName(name, min, max, operationSort == OperationSort.NAME_DESC, offset, limit);
                break;
            case PRICE_ASC:
            case PRICE_DESC:
                result = this.productDao.getAllSortedByPrice(name, min, max, operationSort == OperationSort.PRICE_DESC, offset, limit);
                break;
        }
        return result;
    }

    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max) {
        return productDao.getCount(name, min, max);
    }

    @Override
    public Operation getById(int productId) {
        return productDao.getById(productId).
                orElseThrow(() -> new NotFoundException(String.format("Продукт с id=%d не найден", productId)));
    }

    @Override
    public Operation create(Operation operation) {
        return productDao.save(operation);
    }

    @Override
    public void update(Operation operation) {
        productDao.save(operation);
    }

    @Override
    public void delete(Integer productId) {
        productDao.delete(productId);
    }
}
