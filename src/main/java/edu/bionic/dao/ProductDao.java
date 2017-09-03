package edu.bionic.dao;

import edu.bionic.domain.Operation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Operation> getAll();

    List<Operation> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit);

    List<Operation> getAllSortedByPrice(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit);

    int getCount(String name, BigDecimal min, BigDecimal max);

    Optional<Operation> getById(int productId);

    Operation save(Operation operation);

    boolean delete(int productId);
}
