package edu.bionic.dao.jdbc;

import edu.bionic.dao.ProductDao;
import edu.bionic.domain.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Transactional
public class JdbcProductDao implements ProductDao {

    private RowMapper<Operation> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Operation.class);

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert productInsert;


    @Autowired
    public JdbcProductDao(JdbcTemplate jdbcTemplate,
                          NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                          DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

        productInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Operation> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override
    public List<Operation> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        String sql = "SELECT * FROM products WHERE name LIKE :name " +
                (min == null ? "" : "AND price >= :min ") +
                (max == null ? "" : "AND price <= :max ") +
                "ORDER BY name " + (desc ? "DESC " : "ASC ") +
                "OFFSET :offset LIMIT :limit";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%" )
                .addValue("max", max)
                .addValue("min", min)
                .addValue("offset", offset)
                .addValue("limit", limit);

        return namedParameterJdbcTemplate.query(sql, parameterSource, ROW_MAPPER);
    }

    @Override
    public List<Operation> getAllSortedByPrice(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        String sql = "SELECT * FROM products WHERE name LIKE :name " +
                (min == null ? "" : "AND price >= :min ") +
                (max == null ? "" : "AND price <= :max ") +
                "ORDER BY price " + (desc ? "DESC " : "ASC ") +
                "OFFSET :offset LIMIT :limit";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%" )
                .addValue("max", max)
                .addValue("min", min)
                .addValue("offset", offset)
                .addValue("limit", limit);

        return namedParameterJdbcTemplate.query(sql, parameterSource, ROW_MAPPER);
    }

    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max) {
        String sql = "SELECT COUNT(*) FROM products WHERE name LIKE :name " +
                (min == null ? "" : "AND price >= :min ") +
                (max == null ? "" : "AND price <= :max ");
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%" )
                .addValue("max", max)
                .addValue("min", min);

        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, Integer.class);
    }

    @Override
    public Optional<Operation> getById(int productId) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Operation> operation = jdbcTemplate.query(sql, new Object[]{productId}, ROW_MAPPER);
        return Optional.ofNullable(DataAccessUtils.singleResult(operation));
    }

    @Override
    public Operation save(Operation operation) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", operation.getId())
                .addValue("name", operation.getName())
                .addValue("price", operation.getPrice())
                .addValue("color", operation.getColor().ordinal())
                .addValue("capacity", operation.getCapacity())
                .addValue("display", operation.getDisplay())
                .addValue("description", operation.getDescription());

        if (operation.getId() == null) {
            Number id = productInsert.executeAndReturnKey(parameterSource);
            operation.setId(id.intValue());
        } else {
            String sql = "UPDATE products SET name=:name, price=:price, color=:color, capacity=:capacity, " +
                    "display=:display, description=:description WHERE id=:id";
            namedParameterJdbcTemplate.update(sql, parameterSource);
        }
        return operation;
    }

    @Override
    public boolean delete(int productId) {
        return jdbcTemplate.update("DELETE FROM products WHERE id=?", productId) != 0;
    }

    List<Operation> getByOrder(int orderId) {
        String sql = "SELECT * FROM products LEFT JOIN orders_products ON products.id = orders_products.product_id " +
                "WHERE orders_products.order_id = ?";
        return jdbcTemplate.query(sql, new Object[] {orderId},ROW_MAPPER);
    }
}
