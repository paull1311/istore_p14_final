package edu.bionic.service;

import edu.bionic.domain.Operation;
import edu.bionic.dto.OperationSort;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Operation> getAll();

    List<Operation> getAll(String name, BigDecimal min, BigDecimal max, OperationSort operationSort, int offset, int limit);

    int getCount(String name, BigDecimal min, BigDecimal max);

    Operation getById(int productId);

    Operation create(Operation operation);

    void update(Operation operation);

    void delete(Integer productId);
}
