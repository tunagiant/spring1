package hotae.shoppingmall01.repository;

import hotae.shoppingmall01.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ItemRepository {

    public void save(Item item);

    public Item findById(Integer itemId);

    public List<Item> findAll();

}
