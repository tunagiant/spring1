package hello.itemservice.repository;

import hello.itemservice.domain.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //상품상세
    @Override
    public Item findById(Long id) {
        //depreciated
//        return jdbcTemplate.queryForObject("select * from item where id = ?", new Object[]{id}, itemRowMapper());
        return jdbcTemplate.queryForObject("select * from item where id = ?", itemRowMapper(), id);
    }

    //상품목록
    @Override
    public List<Item> findAll() {
        return jdbcTemplate.query("select * from item", itemRowMapper());
    }

    //저장
    @Override
    public Item save(Item item) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert
                .withTableName("item")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("itemName", item.getItemName());
        parameters.put("quantity", item.getQuantity());
        parameters.put("price", item.getPrice());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        item.setId(key.longValue());
        return item;
    }

    //업데이트
    @Override
    public void update(Long itemId, Item updateParam) {
        jdbcTemplate.update("update item set (itemname, price, quantity) = (?, ?, ?) where id = ?",
                updateParam.getItemName(), updateParam.getPrice(), updateParam.getQuantity(), itemId);
    }

    //삭제
    @Override
    public void delete(Long itemId) {
        jdbcTemplate.update("delete from item where id = ?", itemId);
    }

    //조회매핑(상품상세조회, 상품목록조회)
    private RowMapper<Item> itemRowMapper() {
        return new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {

                Item item = new Item();
                item.setId(rs.getLong("id"));
                item.setItemName(rs.getString("itemName"));
                item.setPrice(rs.getInt("price"));
                item.setQuantity(rs.getInt("quantity"));
                return item;
            }
        };
    }

}
