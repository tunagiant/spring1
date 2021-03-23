package hotae.shoppingmall01.repository;

import hotae.shoppingmall01.item.Item;
import org.springframework.util.StreamUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemRepositoryImpl implements ItemRepository {

    static final Map<Integer, Item> map = new HashMap<>();
    static int itemId = 0;

    @Override
    public void save(Item item) {
        map.put(++itemId, new Item());
    }

    @Override
    public Item findById(Integer itemId) {
        return map.get(itemId);
    }

    @Override
    public List<Item> findAll() {
        return map.values().stream().collect(Collectors.toList());
    }

    public void clear() {
        map.clear();
    }

}
